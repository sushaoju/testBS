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


import com.testbs.entity.allowance;

import com.testbs.service.AllowanceService;

public class AllowanceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AllowanceServlet() {
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

		if (reqCode.equals("findAllowanceInfosForPages")) {
			// 当前页码
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// 页面大小
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// 获取查询参数
			String stuffID = req.getParameter("stuffID");

			AllowanceService allowanceService = new AllowanceService();
			List<allowance> allowanceInfos = allowanceService.getAllowanceForPage(stuffID, pageNo1, pageSize1);
			int total = allowanceService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", allowanceInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		else if (reqCode.equals("findAllAllowanceInfos")) {
			AllowanceService allowanceService = new AllowanceService();
			List<allowance> allowanceInfos = allowanceService.findAllAllowanceInfos();

			JSONObject json = new JSONObject();
			json.put("rows", allowanceInfos);
			json.put("total", allowanceInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findAllowanceInfoById")) {
			// 获取部门编号
			String stuffID = req.getParameter("stuffID");
			// 调用Model，查询该部门
			AllowanceService allowanceService = new AllowanceService();
			allowance allowanceInfo = allowanceService.findAllowanceInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(allowanceInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateAllowance")) {
			// 提取数据
//			int id = (Integer.parseInt(req.getParameter("id")));
			
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			
			int allowanceMonth=(Integer.parseInt(req.getParameter("allowanceMonth")));
			double transAwce=(Double.parseDouble(req.getParameter("transAwce")));
			double foodAwce=(Double.parseDouble(req.getParameter("foodAwce")));
			double houseAwce=(Double.parseDouble(req.getParameter("houseAwce")));
			double cmuAwce=(Double.parseDouble(req.getParameter("cmuAwce")));

			
			
			//entity里要有相应的参数组合
			allowance allowanceInfo = new allowance(stuffName,
					stuffDepart, allowanceMonth,transAwce,foodAwce,houseAwce,cmuAwce);
			// 调用Model
			AllowanceService allowanceService = new AllowanceService();
			int result = allowanceService
					.updateAllowance(allowanceInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("补贴修改成功！");
			} else {
				out.write("补贴修改失败！");
			}
			out.close();
		}
		else if (reqCode.equals("addAllowance")) {
			// 要做新增用户操作
			addAllowance(req, resp);
		} else if (reqCode.equals("delAllowance")) {
			delAllowance(req, resp);
		}

	}

	private void addAllowance(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 获取参数
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart=req.getParameter("stuffDepart");
		int allowanceMonth=(Integer.parseInt(req.getParameter("allowanceMonth")));
		double transAwce=(Double.parseDouble(req.getParameter("transAwce")));
		double foodAwce=(Double.parseDouble(req.getParameter("foodAwce")));
		double houseAwce=(Double.parseDouble(req.getParameter("houseAwce")));
		double cmuAwce=(Double.parseDouble(req.getParameter("cmuAwce")));
		
		
		// 将获取的参数封装成User
		allowance d = new allowance();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setAllowanceMonth(allowanceMonth);
		d.setTransAwce(transAwce);
		d.setFoodAwce(foodAwce);
		d.setHouseAwce(houseAwce);
		d.setCmuAwce(cmuAwce);

		// 调用Model执行数据处理（插入到数据库）s
		AllowanceService allowanceService = new AllowanceService();
		int result = allowanceService.addAllowance(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加补贴信息成功！");
		} else {
			out.write("增加补贴信息失败！");
		}
		out.close();
	}

	private void delAllowance(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 读取参数
		String stuffID = req.getParameter("stuffID");

		// 调用Model，进行删除
		AllowanceService allowanceService = new AllowanceService();
		
		int result = allowanceService.delAllowanceId(stuffID);
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

