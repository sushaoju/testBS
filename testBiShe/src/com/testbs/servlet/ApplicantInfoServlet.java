package com.testbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.testbs.entity.ApplicantInfo;
import com.testbs.service.ApplicantInfoService;

public class ApplicantInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ApplicantInfoServlet() {
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

		if (reqCode.equals("findApplicantInfosForPages")) {
			// 当前页码
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// 页面大小
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// 获取查询参数
			String id = req.getParameter("id");
			String apName = req.getParameter("apName");
			String apDuty = req.getParameter("apDuty");

			ApplicantInfoService applicantInfoService = new ApplicantInfoService();
			List<ApplicantInfo> applicantInfos = applicantInfoService
					.getApplicantInfoForPage(id, apName, apDuty, pageNo1,
							pageSize1);
			int total = applicantInfoService.getTotalCount(id);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", applicantInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}
      else if (reqCode.equals("findAllApplicantInfos")) {
			ApplicantInfoService applicantInfoService = new ApplicantInfoService();
			List<ApplicantInfo> applicantInfos = applicantInfoService
					.findAllApplicantInfos();

			JSONObject json = new JSONObject();
			json.put("rows", applicantInfos);
			json.put("total", applicantInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
      else if (reqCode.equals("findApplicantInfoByCondition")) {
			
			String recruitName = req.getParameter("recruitName"); // 应聘人姓名
			String demandJob = req.getParameter("demandJob"); // 应聘职位
			ApplicantInfoService applicantInfoService = new ApplicantInfoService();
			List<ApplicantInfo> applicantInfos = applicantInfoService.findApplicantInfoByCondition(recruitName,demandJob);
	
			JSONObject json = new JSONObject();
			json.put("rows", applicantInfos);
			json.put("total", applicantInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
      else if (reqCode.equals("findApplicantInfoById")) {
			
			String recruitId = req.getParameter("id"); // 应聘人id

			ApplicantInfoService applicantInfoService = new ApplicantInfoService();
			ApplicantInfo applicantInfo = applicantInfoService.findApplicantInfoById(recruitId);

			JSONObject json = JSONObject.fromObject(applicantInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		else if (reqCode.equals("updateApplicantInfo")) {
			// 提取数据
			// int id = (Integer.parseInt(req.getParameter("id")));

			String apName = req.getParameter("apName");
			String apDuty = req.getParameter("apDuty");
			int apAge = (Integer.parseInt(req.getParameter("apAge")));
			String apEdu = req.getParameter("apEdu");
			String apSkill = req.getParameter("apSkill");
			String apExperience = req.getParameter("apExperience");

			ApplicantInfo applicantInfo = new ApplicantInfo(apName, apDuty,
					apAge, apEdu, apSkill, apExperience);
			// 调用Model
			ApplicantInfoService applicantInfoService = new ApplicantInfoService();
			int result = applicantInfoService
					.updateApplicantInfo(applicantInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("应聘人员修改成功！");
			} else {
				out.write("应聘人员修改失败！");
			}
			out.close();
		} else if (reqCode.equals("addApplicantInfo")) {
			// 要做新增用户操作
			addApplicantInfo(req, resp);
		} else if (reqCode.equals("delApplicantInfo")) {
			delApplicantInfo(req, resp);
		}

	}

	private void addApplicantInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 获取参数
		int id = (Integer.parseInt(req.getParameter("id")));
		String apName = req.getParameter("apName");
		String apDuty = req.getParameter("apDuty");
		int apAge = (Integer.parseInt(req.getParameter("apAge")));
		String apEdu = req.getParameter("apEdu");
		String apSkill = req.getParameter("apSkill");
		String apExperience = req.getParameter("apExperience");

		// 将获取的参数封装成User
		ApplicantInfo d = new ApplicantInfo();
		// d.setId(id);
		d.setId(id);
		d.setApName(apName);
		d.setApDuty(apDuty);
		d.setApAge(apAge);
		d.setApEdu(apEdu);
		d.setApSkill(apSkill);
		d.setApExperience(apExperience);

		// 调用Model执行数据处理（插入到数据库）s
		ApplicantInfoService applicantInfoService = new ApplicantInfoService();
		int result = applicantInfoService.addApplicantInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加应聘人员成功！");
		} else {
			out.write("增加应聘人员失败！");
		}
		out.close();
	}

	private void delApplicantInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 读取参数
		String id = req.getParameter("id");

		// 调用Model，进行删除
		ApplicantInfoService applicantInfoService = new ApplicantInfoService();

		int result = applicantInfoService.delApplicantInfoId(id);
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
