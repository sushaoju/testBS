package com.testbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.testbs.entity.JobInfo;
import com.testbs.entity.StuffInfo;
import com.testbs.entity.stuffJob;
import com.testbs.service.JobInfoService;
import com.testbs.service.StuffInfoService;

import net.sf.json.JSONObject;

public class StuffInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StuffInfoServlet() {
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

		if (reqCode.equals("findStuffInfosForPages")) {
			// 当前页码
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// 页面大小
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// 获取查询参数
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");

			StuffInfoService stuffInfoService = new StuffInfoService();
			List<StuffInfo> stuffInfos = stuffInfoService.getStuffInfoForPage(
					stuffID, stuffName, pageNo1, pageSize1);
			int total = stuffInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", stuffInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findAllStuffInfos")) {
			StuffInfoService stuffInfoService = new StuffInfoService();
			List<StuffInfo> stuffInfos = stuffInfoService.findAllStuffInfos();
			
			JobInfoService jobInfoService = new JobInfoService();
			List<JobInfo> jobInfos  = jobInfoService.findAllJobInfos();
			
			JSONObject json = new JSONObject();
			
			json.put("rows1", stuffInfos);
			json.put("rows2", jobInfos);
			json.put("total", stuffInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
       else if (reqCode.equals("findStuffInfoByCondition")) {
			
			String stuffName = req.getParameter("stuffName"); //姓名
			String stuffId = req.getParameter("stuffId"); // 工号
			String depName = req.getParameter("depName"); // 部门ID
			
			StuffInfoService stuffInfoService = new StuffInfoService();
			List<stuffJob> stuffJobInfos = stuffInfoService.findStuffInfoByCondition(stuffId,stuffName,depName);
	
			JSONObject json = new JSONObject();
			json.put("rows", stuffJobInfos);
			json.put("total",stuffJobInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		else if (reqCode.equals("findStuffInfoById")) {
			// 获取部门编号
			String stuffID = req.getParameter("stuffID");
			// 调用Model，查询该部门
			StuffInfoService stuffInfoService = new StuffInfoService();
			StuffInfo stuffInfo = stuffInfoService.findStuffInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(stuffInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateStuffInfo")) {
			// 提取数据
			// int id = (Integer.parseInt(req.getParameter("id")));

			String stuffId= req.getParameter("stuffId");
			String stuffName = req.getParameter("stuffName");
			String stuffBirth = req.getParameter("stuffBirth");
			String stuffSex = req.getParameter("stuffSex");
			String stuffNation = req.getParameter("stuffNation");
			String stuffAddress = req.getParameter("stuffAddress");
			String stuffTel = req.getParameter("stuffTel");
			String stuffEmail = req.getParameter("stuffEmail");
			String stuffEdu = req.getParameter("stuffEdu");
			String stuffColleage = req.getParameter("stuffColleage");
			String stuffProfession = req.getParameter("stuffProfession");
			String stuffGrade = req.getParameter("stuffGrade");
			String stuffWedding = req.getParameter("stuffWedding");
			String stuffSkill = req.getParameter("stuffSkill");

			StuffInfo stuffInfo = new StuffInfo(stuffName, stuffBirth,
					stuffSex, stuffNation, stuffAddress, stuffTel, stuffEmail,
					stuffEdu, stuffColleage, stuffProfession, stuffGrade,
					stuffWedding, stuffSkill,stuffId);
			// 调用Model
			StuffInfoService stuffInfoService = new StuffInfoService();
			int result = stuffInfoService.updateStuffInfo(stuffInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("员工信息修改成功！");
			} else {
				out.write("员工信息修改失败！");
			}
			out.close();
		} else if (reqCode.equals("addStuffInfo")) {
			// 要做新增用户操作
			addStuffInfo(req, resp);
		} else if (reqCode.equals("delStuffInfo")) {
			delStuffInfo(req, resp);
		}

	}

	private void addStuffInfo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 获取参数
		//int id = (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffBirth = req.getParameter("stuffBirth");
		String stuffSex = req.getParameter("stuffSex");
		String stuffNation = req.getParameter("stuffNation");
		String stuffAddress = req.getParameter("stuffAddress");
		String stuffTel = req.getParameter("stuffTel");
		String stuffEmail = req.getParameter("stuffEmail");
		String stuffEdu = req.getParameter("stuffEdu");
		String stuffColleage = req.getParameter("stuffColleage");
		String stuffProfession = req.getParameter("stuffProfession");
		String stuffGrade = req.getParameter("stuffGrade");
		String stuffWedding = req.getParameter("stuffWedding");
		String stuffSkill = req.getParameter("stuffSkill");

		// 将获取的参数封装成User
		StuffInfo d = new StuffInfo();
		//d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffBirth(stuffBirth);
		d.setStuffSex(stuffSex);
		d.setStuffNation(stuffNation);
		d.setStuffAddress(stuffAddress);
		d.setStuffTel(stuffTel);
		d.setStuffEmail(stuffEmail);
		d.setStuffEdu(stuffEdu);
		d.setStuffColleage(stuffColleage);
		d.setStuffProfession(stuffProfession);
		d.setStuffGrade(stuffGrade);
		d.setStuffWedding(stuffWedding);
		d.setStuffSkill(stuffSkill);

		// 调用Model执行数据处理（插入到数据库）s
		StuffInfoService stuffInfoService = new StuffInfoService();
		int result = stuffInfoService.addStuffInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加与员工信息成功！");
		} else {
			out.write("增加员工信息失败！");
		}
		out.close();
	}

	private void delStuffInfo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 读取参数
		String stuffID = req.getParameter("stuffID");

		// 调用Model，进行删除
		StuffInfoService stuffInfoService = new StuffInfoService();

		int result = stuffInfoService.delStuffInfoId(stuffID);
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
