package com.testbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testbs.entity.OverWorkInfo;
import com.testbs.service.OverWorkInfoService;

import net.sf.json.JSONObject;



public class OverWorkServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OverWorkServlet() {
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

		if (reqCode.equals("findAdjustRestInfosForPages")) {
			// 当前页码
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// 页面大小
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// 获取查询参数
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");
			OverWorkInfoService overworkInfoService = new OverWorkInfoService();
			List<OverWorkInfo> overworkInfos = overworkInfoService
					.getOverWorkInfoForPage(stuffID,stuffName, pageNo1, pageSize1);
			int total = overworkInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", overworkInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		else if (reqCode.equals("findAllOverWorkInfos")) {
			OverWorkInfoService overworkInfoService = new OverWorkInfoService();
			List<OverWorkInfo> overworkInfos = overworkInfoService.findAllOverWorkInfos();

			JSONObject json = new JSONObject();
			json.put("rows", overworkInfos);
			json.put("total", overworkInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if (reqCode.equals("findOverWorkInfoByCondition")) {
			
			String stuffName = req.getParameter("stuffName"); //姓名
			String stuffID = req.getParameter("stuffID"); // 工号
			String stuffDepart = req.getParameter("stuffDepart"); // 部门
			
			OverWorkInfoService overworkInfoService = new OverWorkInfoService();
			List<OverWorkInfo> overworkInfos = overworkInfoService.findOverWorkInfoByCondition(stuffID,stuffName,stuffDepart);
	
			JSONObject json = new JSONObject();
			json.put("rows", overworkInfos);
			json.put("total",overworkInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}  else if (reqCode.equals("findAdjustRestInfoById")) {
			// 获取部门编号
			String stuffID = req.getParameter("stuffID");
			// 调用Model，查询该部门
			OverWorkInfoService overworkInfoService = new OverWorkInfoService();
			OverWorkInfo overworkInfo = overworkInfoService.findOverWorkInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(overworkInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateOverWorkInfo")) {
			// 提取数据
//			int id = (Integer.parseInt(req.getParameter("id")));
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			String overworkStart = req.getParameter("overworkStart");
			String overworkEnd = req.getParameter("overworkEnd");
			double overworkHours=(Double.parseDouble(req.getParameter("overworkHours")));
			String overworkReason = req.getParameter("overworkReason");
			double overworkMoney=(Double.parseDouble(req.getParameter("overworkMoney")));
			String overworkApprover = req.getParameter("overworkApprover");

		
			//entity里要有相应的参数组合
			OverWorkInfo overworkInfo = new OverWorkInfo(stuffID,stuffName,
					stuffDepart, overworkStart,overworkEnd,overworkHours,overworkReason,overworkMoney,overworkApprover);
			// 调用Model
			OverWorkInfoService overworkInfoService = new OverWorkInfoService();
			int result = overworkInfoService
					.updateOverWorkInfo(overworkInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("加班信息修改成功！");
			} else {
				out.write("加班信息修改失败！");
			}
			out.close();
		}
		else if (reqCode.equals("addOverWorkInfo")) {
			// 要做新增用户操作
			addOverWorkInfo(req, resp);
		} else if (reqCode.equals("delOverWorkInfo")) {
			delOverWorkInfo(req, resp);
		}

	}

	private void addOverWorkInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 获取参数
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart=req.getParameter("stuffDepart");
		String overworkStart = req.getParameter("overworkStart");
		String overworkEnd = req.getParameter("overworkEnd");
		double overworkHours=(Double.parseDouble(req.getParameter("overworkHours")));
		String overworkReason = req.getParameter("overworkReason");
		double overworkMoney=(Double.parseDouble(req.getParameter("overworkMoney")));
		String overworkApprover = req.getParameter("overworkApprover");
		// 将获取的参数封装成User
		OverWorkInfo d = new OverWorkInfo();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setOverworkStart(overworkStart);
		d.setOverworkEnd(overworkEnd);
		d.setOverworkHours(overworkHours);
		d.setOverworkReason(overworkReason);
		d.setOverworkMoney(overworkMoney);
		d.setOverworkApprover(overworkApprover);

		// 调用Model执行数据处理（插入到数据库）s
		OverWorkInfoService overworkInfoService = new OverWorkInfoService();
		int result = overworkInfoService.addOverWorkInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加加班信息成功！");
		} else {
			out.write("增加加班信息失败！");
		}
		out.close();
	}

	private void delOverWorkInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 读取参数
		String stuffID = req.getParameter("stuffID");

		// 调用Model，进行删除
		OverWorkInfoService overworkInfoService = new OverWorkInfoService();
		
		int result = overworkInfoService.delOverWorkInfoId(stuffID);
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