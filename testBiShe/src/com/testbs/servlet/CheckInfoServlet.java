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

import com.testbs.entity.CheckInfo;

import com.testbs.service.CheckInfoService;

public class CheckInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckInfoServlet() {
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

		if (reqCode.equals("findCheckInfosForPages")) {
			// 当前页码
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// 页面大小
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// 获取查询参数
			String stuffID = req.getParameter("stuffID");

			CheckInfoService checkInfoService = new CheckInfoService();
			List<CheckInfo> checkInfos = checkInfoService.getCheckInfoForPage(
					stuffID, pageNo1, pageSize1);
			int total = checkInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", checkInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findAllCheckInfos")) {
			CheckInfoService checkInfoService = new CheckInfoService();
			List<CheckInfo> checkInfos = checkInfoService.findAllCheckInfos();

			JSONObject json = new JSONObject();
			json.put("rows", checkInfos);
			json.put("total", checkInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findCheckInfoById")) {
			// 获取部门编号
			String stuffID = req.getParameter("stuffID");
			// 调用Model，查询该部门
			CheckInfoService checkInfoService = new CheckInfoService();
			CheckInfo checkInfo = checkInfoService.findCheckInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(checkInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateCheckInfo")) {
			// 提取数据
			// int id = (Integer.parseInt(req.getParameter("id")));

			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			String stuffShift = req.getParameter("stuffShift");
			double workHour = (Double.parseDouble(req.getParameter("workHour")));
			String workDate = req.getParameter("workDate");
			double lateHour = (Double.parseDouble(req.getParameter("lateHour")));
			double absentHour = (Double.parseDouble(req
					.getParameter("absentHour")));

			CheckInfo checkInfo = new CheckInfo(stuffName, stuffDepart,
					stuffShift, workHour, workDate, lateHour, absentHour);
			// 调用Model
			CheckInfoService checkInfoService = new CheckInfoService();
			int result = checkInfoService.updateCheckInfo(checkInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("考勤信息修改成功！");
			} else {
				out.write("考勤信息修改失败！");
			}
			out.close();
		} else if (reqCode.equals("addCheckInfo")) {
			// 要做新增用户操作
			addCheckInfo(req, resp);
		} else if (reqCode.equals("delCheckInfo")) {
			delCheckInfo(req, resp);
		}

	}

	private void addCheckInfo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 获取参数
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart = req.getParameter("stuffDepart");
		String stuffShift = req.getParameter("stuffShift");
		double workHour = (Double.parseDouble(req.getParameter("workHour")));
		String workDate = req.getParameter("workDate");
		double lateHour = (Double.parseDouble(req.getParameter("lateHour")));
		double absentHour = (Double.parseDouble(req.getParameter("absentHour")));

		// 将获取的参数封装成User
		CheckInfo d = new CheckInfo();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setStuffShift(stuffShift);
		d.setWorkHour(workHour);
		d.setWorkDate(workDate);
		d.setLateHour(lateHour);
		d.setAbsentHour(absentHour);

		// 调用Model执行数据处理（插入到数据库）s
		CheckInfoService checkInfoService = new CheckInfoService();
		int result = checkInfoService.addCheckInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加考勤信息成功！");
		} else {
			out.write("增加考勤信息失败！");
		}
		out.close();
	}

	private void delCheckInfo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 读取参数
		String stuffID = req.getParameter("stuffID");

		// 调用Model，进行删除
		CheckInfoService checkInfoService = new CheckInfoService();

		int result = checkInfoService.delCheckInfoId(stuffID);
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
