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


import com.testbs.entity.JobInfo;
import com.testbs.service.JobInfoService;

public class JobInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public JobInfoServlet() {
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

		if (reqCode.equals("findJobInfosForPages")) {
			// 当前页码
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// 页面大小
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// 获取查询参数
			String stuffID = req.getParameter("stuffID");

			JobInfoService jobInfoService = new JobInfoService();
			List<JobInfo> jobInfos = jobInfoService.getJobInfoForPage(stuffID, pageNo1, pageSize1);
			int total = jobInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", jobInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		else if (reqCode.equals("findAllJobInfos")) {
			JobInfoService jobInfoService = new JobInfoService();
			List<JobInfo> jobInfos  = jobInfoService.findAllJobInfos();

			JSONObject json = new JSONObject();
			json.put("rows", jobInfos);
			json.put("total", jobInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
			
		} 
		else if (reqCode.equals("findJobInfoById")) {
			// 获取部门编号
			String stuffID = req.getParameter("stuffID");
			// 调用Model，查询该部门
			JobInfoService jobInfoService = new JobInfoService();
			JobInfo jobInfo = jobInfoService.findJobInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(jobInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		else if (reqCode.equals("updateJobInfo")) {
			// 提取数据
//			int id = (Integer.parseInt(req.getParameter("id")));
			String stuffID = req.getParameter("stuffID");
			String adjustMoney = req.getParameter("adjustMoney");  
			String adjustJob = req.getParameter("adjustJob");     
			
			JobInfo jobInfo = new JobInfo( stuffID,adjustJob,adjustMoney);
			// 调用Model
			
			JobInfoService jobInfoService = new JobInfoService();
			int result = jobInfoService.updateJobInfo(jobInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("岗位信息修改成功！");
			} else {
				out.write("岗位信息修改失败！");
			}
			out.close();
		}
		else if (reqCode.equals("addJobInfo")) {
			// 要做新增用户操作
			addJobInfo(req, resp);
		} else if (reqCode.equals("delJobInfo")) {
			delJobInfo(req, resp);
		}

	}

	private void addJobInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 获取参数
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart = req.getParameter("stuffDepart");
		String stuffDuty = req.getParameter("stuffDuty");
		String stuffStatus = req.getParameter("stuffStatus");
		String stuffEntryDate = req.getParameter("stuffEntryDate");
		Double stuffMoney = Double.parseDouble(req.getParameter("stuffMoney"));
		String contractBegin = req.getParameter("contractBegin");
		String contractEnd = req.getParameter("contractEnd");     
		String adjustMoney = req.getParameter("adjustMoney");   
		String adjustJob = req.getParameter("adjustJob");   
		
		
		// 将获取的参数封装成User
		JobInfo d = new JobInfo();
		// d.setId(id);
		d.setStuffID(stuffID);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setStuffDuty(stuffDuty);
		d.setStuffStatus(stuffStatus);
		d.setStuffEntryDate(stuffEntryDate);
		d.setContractBegin(contractBegin);
		d.setContractEnd(contractEnd);
		d.setStuffMoney(stuffMoney);
		d.setAdjustMoney(adjustMoney);
		d.setAdjustJob(adjustJob);
		

		// 调用Model执行数据处理（插入到数据库）s
		JobInfoService jobInfoService = new JobInfoService();
		int result = jobInfoService.addJobInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加岗位信息成功！");
		} else {
			out.write("增加岗位信息失败！");
		}
		out.close();
	}

	private void delJobInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 读取参数
		String stuffID = req.getParameter("stuffID");

		// 调用Model，进行删除
		JobInfoService jobInfoService = new JobInfoService();
		
		int result = jobInfoService.delJobInfoId(stuffID);
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
		private Date dateFormat(String dateStr) throws ParseException {
			Date date=new Date();
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    date = sdf.parse(dateStr);
				
			}catch(ParseException e){
				System.out.println(e.getMessage());
			}
			return date;
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
