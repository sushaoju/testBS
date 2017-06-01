package com.testbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testbs.entity.WorkLeaveInfo;
import com.testbs.service.WorkLeaveInfoService;

import net.sf.json.JSONObject;

public class WorkLeaveServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WorkLeaveServlet() {
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

		if (reqCode.equals("findWorkLeaveInfosForPages")) {
			// 当前页码
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// 页面大小
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// 获取查询参数
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");

			WorkLeaveInfoService workleaveInfoService = new WorkLeaveInfoService();
			List<WorkLeaveInfo> workleaveInfos = workleaveInfoService
					.getWorkLeaveInfoForPage(stuffID, stuffName, pageNo1,
							pageSize1);
			int total = workleaveInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", workleaveInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findAllWorkLeaveInfos")) {
			WorkLeaveInfoService workleaveInfoService = new WorkLeaveInfoService();
			List<WorkLeaveInfo> workleaveInfos = workleaveInfoService
					.findAllWorkLeaveInfos();

			JSONObject json = new JSONObject();
			json.put("rows", workleaveInfos);
			json.put("total", workleaveInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if (reqCode.equals("findWorkLeaveInfoByCondition")) {
			
			String stuffName = req.getParameter("stuffName"); //姓名
			String stuffID = req.getParameter("stuffID"); // 工号
			String stuffDepart = req.getParameter("stuffDepart"); // 部门
			
			WorkLeaveInfoService workleaveInfoService = new WorkLeaveInfoService();
			List<WorkLeaveInfo> workleaveInfos = workleaveInfoService.findWorkLeaveInfoByCondition(stuffID,stuffName,stuffDepart);
	
			JSONObject json = new JSONObject();
			json.put("rows", workleaveInfos);
			json.put("total",workleaveInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}  else if (reqCode.equals("findWorkLeaveInfoById")) {
			// 获取部门编号
			String stuffID = req.getParameter("stuffID");
			// 调用Model，查询该部门
			WorkLeaveInfoService workleaveInfoService = new WorkLeaveInfoService();
			WorkLeaveInfo workleaveInfo = workleaveInfoService
					.findWorkLeaveInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(workleaveInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateWorkLeaveInfo")) {
			// 提取数据
			// int id = (Integer.parseInt(req.getParameter("id")));
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			String leaveBegin = req.getParameter("leaveBegin");
			String leaveEnd = req.getParameter("leaveEnd");
			double leaveHours = (Double.parseDouble(req
					.getParameter("leaveHours")));
			String leaveType = req.getParameter("leaveType");
			String leaveReason = req.getParameter("leaveReason");
			String approver = req.getParameter("approver");
			double leaveMoney = (Double.parseDouble(req
					.getParameter("leaveMoney")));

			// entity里要有相应的参数组合
			WorkLeaveInfo workleaveInfo = new WorkLeaveInfo(stuffID,stuffName,
					stuffDepart, leaveBegin, leaveEnd, leaveHours, leaveType,
					leaveReason, approver, leaveMoney);
			// 调用Model
			WorkLeaveInfoService workleaveInfoService = new WorkLeaveInfoService();
			int result = workleaveInfoService
					.updateWorkLeaveInfo(workleaveInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("请假信息修改成功！");
			} else {
				out.write("请假信息修改失败！");
			}
			out.close();
		} else if (reqCode.equals("addWorkLeaveInfo")) {
			// 要做新增用户操作
			addWorkLeaveInfo(req, resp);
		} else if (reqCode.equals("delWorkLeaveInfo")) {
			delWorkLeaveInfo(req, resp);
		}

	}

	private void addWorkLeaveInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 获取参数
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart = req.getParameter("stuffDepart");
		String leaveBegin = req.getParameter("leaveBegin");
		String leaveEnd = req.getParameter("leaveEnd");
		double leaveHours = (Double.parseDouble(req.getParameter("leaveHours")));
		String leaveType = req.getParameter("leaveType");
		String leaveReason = req.getParameter("leaveReason");
		String approver = req.getParameter("approver");
		double leaveMoney = (Double.parseDouble(req.getParameter("leaveMoney")));

		// 将获取的参数封装成User
		WorkLeaveInfo d = new WorkLeaveInfo();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setLeaveBegin(leaveBegin);
		d.setLeaveEnd(leaveEnd);
		d.setLeaveHours(leaveHours);
		d.setLeaveType(leaveType);
		d.setLeaveReason(leaveReason);
		d.setApprover(approver);
		d.setLeaveMoney(leaveMoney);

		// 调用Model执行数据处理（插入到数据库）s
		WorkLeaveInfoService workleaveInfoService = new WorkLeaveInfoService();
		int result = workleaveInfoService.addWorkLeaveInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加调休信息成功！");
		} else {
			out.write("增加调休信息失败！");
		}
		out.close();
	}

	private void delWorkLeaveInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 读取参数
		String stuffID = req.getParameter("stuffID");

		// 调用Model，进行删除
		WorkLeaveInfoService workleaveInfoService = new WorkLeaveInfoService();

		int result = workleaveInfoService.delWorkLeaveInfoId(stuffID);
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
