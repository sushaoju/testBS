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

import com.testbs.entity.AdjustRestInfo;
import com.testbs.entity.TrainInfo;

import com.testbs.service.AdjustRestInfoService;
import com.testbs.service.TrainInfoService;


public class AdjustRestServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdjustRestServlet() {
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

			AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
			List<AdjustRestInfo> adjustrestInfos = adjustrestInfoService
					.getAdjustRestInfoForPage(stuffID,stuffName, pageNo1, pageSize1);
			int total = adjustrestInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", adjustrestInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		else if (reqCode.equals("findAllAdjustRestInfos")) {
			AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
			List<AdjustRestInfo> adjustrestInfos = adjustrestInfoService.findAllAdjustRestInfos();

			JSONObject json = new JSONObject();
			json.put("rows", adjustrestInfos);
			json.put("total", adjustrestInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		
else if (reqCode.equals("findAdjustRestInfoByCondition")) {
			
			String stuffName = req.getParameter("stuffName"); //姓名
			String stuffID = req.getParameter("stuffID"); // 工号
			String stuffDepart = req.getParameter("stuffDepart"); // 部门
			
			AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
			List<AdjustRestInfo> adjustrestInfos = adjustrestInfoService.findAdjustRestInfoByCondition(stuffID,stuffName,stuffDepart);
	
			JSONObject json = new JSONObject();
			json.put("rows", adjustrestInfos);
			json.put("total",adjustrestInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		
		else if (reqCode.equals("findAdjustRestInfoById")) {
			// 获取部门编号
			String stuffID = req.getParameter("stuffID");
			// 调用Model，查询该部门
			AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
			AdjustRestInfo adjustrestInfo = adjustrestInfoService.findAdjustRestInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(adjustrestInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateAdjustRestInfo")) {
			// 提取数据
//			int id = (Integer.parseInt(req.getParameter("id")));
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			String adjustType = req.getParameter("adjustType");
			String adjustBefore = req.getParameter("adjustBefore");
			String adjustAfter = req.getParameter("adjustAfter");
			String adjustApprover = req.getParameter("adjustApprover");

		
			//entity里要有相应的参数组合
			AdjustRestInfo adjustrestInfo = new AdjustRestInfo(stuffID,stuffName,
					stuffDepart, adjustType,adjustBefore,adjustAfter,adjustApprover);
			// 调用Model
			AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
			int result = adjustrestInfoService
					.updateAdjustRestInfo(adjustrestInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("调休修改成功！");
			} else {
				out.write("调休修改失败！");
			}
			out.close();
		}
		else if (reqCode.equals("addAdjustRestInfo")) {
			// 要做新增用户操作
			addAdjustRestInfo(req, resp);
		} else if (reqCode.equals("delAdjustRestInfo")) {
			delAdjustRestInfo(req, resp);
		}

	}

	private void addAdjustRestInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 获取参数
		//int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart=req.getParameter("stuffDepart");
		String adjustType = req.getParameter("adjustType");
		String adjustBefore = req.getParameter("adjustBefore");
		String adjustAfter = req.getParameter("adjustAfter");
		String adjustApprover=req.getParameter("adjustApprover");
		
		// 将获取的参数封装成User
		AdjustRestInfo d = new AdjustRestInfo();
		//d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setAdjustType(adjustType);
		d.setAdjustBefore(adjustBefore);
		d.setAdjustAfter(adjustAfter);
		d.setAdjustApprover(adjustApprover);

		// 调用Model执行数据处理（插入到数据库）s
		AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
		int result = adjustrestInfoService.addAdjustRestInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加调休信息成功！");
		} else {
			out.write("增加调休信息失败！");
		}
		out.close();
	}

	private void delAdjustRestInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 读取参数
		String stuffID = req.getParameter("stuffID");

		// 调用Model，进行删除
		AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
		
		int result = adjustrestInfoService.delAdjustRestInfoId(stuffID);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if (result > 0) {
			out.write("删除成功！");
		} else {
			out.write("删除失败！");
		}
		out.close();
	}
	
	//日期字符串 转换出 日期
//	private Date dateFormat(String dateStr) throws ParseException {
//		Date date=new Date();
//		try{
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		    date = sdf.parse(dateStr);
//			
//		}catch(ParseException e){
//			System.out.println(e.getMessage());
//		}
//		return date;
//	}
	
	
	
	
	
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

