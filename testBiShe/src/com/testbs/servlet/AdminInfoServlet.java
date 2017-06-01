package com.testbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.testbs.entity.AdminInfo;
import com.testbs.entity.TrainInfo;
import com.testbs.service.AdminInfoService;
import com.testbs.service.TrainInfoService;

public class AdminInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminInfoServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		// 获取请求码
		String reqCode = req.getParameter("reqCode");

		if (reqCode.equals("findAdminInfosForPages")) {
			// 当前页码
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// 页面大小
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// 获取查询参数
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");

			AdminInfoService adminInfoService = new AdminInfoService();
			List<AdminInfo> adminInfos = adminInfoService.getAdminInfoForPage(
					stuffID, stuffName,pageNo1, pageSize1);
			int total = adminInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", adminInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findAllAdminInfos")) {
			AdminInfoService adminInfoService = new AdminInfoService();
			List<AdminInfo> adminInfos = adminInfoService.findAllAdminInfos();

			JSONObject json = new JSONObject();
			json.put("rows", adminInfos);
			json.put("total", adminInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		
	else if (reqCode.equals("findAdminInfoByCondition")) {
				
				String stuffName = req.getParameter("stuffName"); //姓名
				String stuffID = req.getParameter("stuffID"); // 工号
				
				AdminInfoService adminInfoService = new AdminInfoService();
				List<AdminInfo> adminInfos = adminInfoService.findAdminInfoByCondition(stuffID,stuffName);
		
				JSONObject json = new JSONObject();
				json.put("rows", adminInfos);
				json.put("total",adminInfos.size());
	
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.write(json.toString());
				out.close();
			} 
		
		else if (reqCode.equals("findAdminInfoById")) {
			// 获取部门编号
			String stuffID = req.getParameter("stuffID");
			// 调用Model，查询该部门
			AdminInfoService adminInfoService = new AdminInfoService();
			AdminInfo adminInfo = adminInfoService.findAdminInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(adminInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateAdminInfo")) {
			// 提取数据
			// int id = (Integer.parseInt(req.getParameter("id")));

			String stuffID = req.getParameter("stuffID");
			String account = req.getParameter("account");
			String password = req.getParameter("password");

			AdminInfo adminInfo = new AdminInfo(stuffID, account, password);
			// 调用Model
			AdminInfoService adminInfoService = new AdminInfoService();
			int result = adminInfoService.updateAdminInfo(adminInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("管理员修改成功！");
			} else {
				out.write("管理员修改失败！");
			}
			out.close();
		} 
		else if (reqCode.equals("addAdminInfo")) {
			// 要做新增用户操作
			addAdminInfo(req, resp);
		}
		else if (reqCode.equals("delAdminInfo")) {
			delAdminInfo(req, resp);
		}

	}

	private void addAdminInfo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 获取参数
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String resignDate = req.getParameter("resignDate");
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		// Date date=new Date();
		// try {
		// date = dateFormat(resignDate);
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// 将获取的参数封装成User
		AdminInfo d = new AdminInfo();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setResignDate(resignDate);
		d.setAccount(account);
		d.setPassword(password);

		// 调用Model执行数据处理（插入到数据库）s
		AdminInfoService adminInfoService = new AdminInfoService();
		int result = adminInfoService.addAdminInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加管理员成功！");
		} else {
			out.write("增加管理员失败！");
		}
		out.close();
	}

	private void delAdminInfo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 读取参数
		String stuffID = req.getParameter("stuffID");

		// 调用Model，进行删除
		AdminInfoService adminInfoService = new AdminInfoService();

		int result = adminInfoService.delAdminInfoId(stuffID);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if (result > 0) {
			out.write("删除成功！");
		} else {
			out.write("删除失败！");
		}
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
