package com.testbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testbs.entity.RetireInfo;
import com.testbs.service.RetireInfoService;

import net.sf.json.JSONObject;



public class RetireInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RetireInfoServlet() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 获取请求码
		String reqCode = req.getParameter("reqCode");

		if (reqCode.equals("findRetireInfosForPages")) {
			// 当前页码
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// 页面大小
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// 获取查询参数
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");

			RetireInfoService retireInfoService = new RetireInfoService();
			List<RetireInfo> retireInfos = retireInfoService
					.getRetireInfoForPage(stuffID,stuffName, pageNo1, pageSize1);
			int total = retireInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", retireInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findAllRetireInfos")) {
			RetireInfoService retireInfoService = new RetireInfoService();
			List<RetireInfo> retireInfos = retireInfoService.findAllRetireInfos();

			JSONObject json = new JSONObject();
			json.put("rows", retireInfos);
			json.put("total", retireInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 	 else if (reqCode.equals("findRetireInfoByCondition")) {
			
			String stuffName = req.getParameter("stuffName"); //姓名
			String stuffID = req.getParameter("stuffID"); // 工号
		
			
			RetireInfoService retireInfoService = new RetireInfoService();
			List<RetireInfo> retireInfos = retireInfoService.findRetireInfoByCondition(stuffID,stuffName);
	
			JSONObject json = new JSONObject();
			json.put("rows", retireInfos);
			json.put("total",retireInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
	else if (reqCode.equals("findRetireInfoById")) {
			// 获取部门编号
			String stuffID = req.getParameter("stuffID");
			// 调用Model，查询该部门
			RetireInfoService retireInfoService = new RetireInfoService();
			RetireInfo retireInfo = retireInfoService
					.findRetireInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(retireInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateRetireInfo")) {
			// 提取数据
			// int id = (Integer.parseInt(req.getParameter("id")));
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			String stuffDuty = req.getParameter("stuffDuty");
			String stuffEntryDate = req.getParameter("stuffEntryDate");
			String retireDate = req.getParameter("retireDate");
			String retireInterface = req.getParameter("retireInterface");
			double retireMoney=(Double.parseDouble(req.getParameter("retireMoney")));

			RetireInfo retireInfo = new RetireInfo(stuffID,stuffName,
					stuffDepart, stuffDuty, stuffEntryDate, retireDate,
					retireInterface,retireMoney);
			// 调用Model
			RetireInfoService retireInfoService = new RetireInfoService();
			int result = retireInfoService
					.updateRetireInfo(retireInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("退休信息修改成功！");
			} else {
				out.write("退休信息修改失败！");
			}
			out.close();
		} else if (reqCode.equals("addRetireInfo")) {
			// 要做新增用户操作
			addRetireInfo(req, resp);
		} else if (reqCode.equals("delRetireInfo")) {
			delRetireInfo(req, resp);
		}

	}

	private void addRetireInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 获取参数
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart = req.getParameter("stuffDepart");
		String stuffDuty = req.getParameter("stuffDuty");
		String stuffEntryDate = req.getParameter("stuffEntryDate");
		String retireDate = req.getParameter("retireDate");
		String retireInterface = req.getParameter("retireInterface");
		double retireMoney=Double.parseDouble(req.getParameter("retireMoney"));

		// 将获取的参数封装成User
		RetireInfo d = new RetireInfo();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setStuffDuty(stuffDuty);
		d.setStuffEntryDate(stuffEntryDate);
		d.setRetireDate(retireDate);
		d.setRetireInterface(retireInterface);
		d.setRetireMoney(retireMoney);

		// 调用Model执行数据处理（插入到数据库）s
		RetireInfoService retireInfoService = new RetireInfoService();
		int result = retireInfoService.addRetireInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加退休信息成功！");
		} else {
			out.write("增加退休信息失败！");
		}
		out.close();
	}

	private void delRetireInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 读取参数
		String stuffID = req.getParameter("stuffID");

		// 调用Model，进行删除
		RetireInfoService retireInfoService = new RetireInfoService();

		int result = retireInfoService.delRetireInfoId(stuffID);
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