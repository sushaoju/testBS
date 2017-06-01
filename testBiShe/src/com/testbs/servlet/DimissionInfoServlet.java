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

import com.testbs.entity.DimissionInfo;

import com.testbs.service.DimissionInfoService;

public class DimissionInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DimissionInfoServlet() {
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

		if (reqCode.equals("findDimissionInfosForPages")) {
			// 当前页码
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// 页面大小
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// 获取查询参数
			String stuffID = req.getParameter("stuffID");

			DimissionInfoService dimissionInfoService = new DimissionInfoService();
			List<DimissionInfo> dimissionInfos = dimissionInfoService
					.getDimissionInfoForPage(stuffID, pageNo1, pageSize1);
			int total = dimissionInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", dimissionInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}
		else if (reqCode.equals("findAllDimissionInfos")) {
			DimissionInfoService dimissionInfoService = new DimissionInfoService();
			List<DimissionInfo> dimissionInfos = dimissionInfoService
					.findAllDimissionInfos();

			JSONObject json = new JSONObject();
			json.put("rows", dimissionInfos);
			json.put("total", dimissionInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		
		 else if (reqCode.equals("findDimissionInfoByCondition")) {
				
				String stuffName = req.getParameter("stuffName"); //姓名
				String stuffID = req.getParameter("stuffID"); // 工号
				String stuffDepart = req.getParameter("stuffDepart"); // 部门
				
				DimissionInfoService dimissionInfoService = new DimissionInfoService();
				List<DimissionInfo> dimissionInfos = dimissionInfoService.findDimissionInfoByCondition(stuffID,stuffName,stuffDepart);
		
				JSONObject json = new JSONObject();
				json.put("rows", dimissionInfos);
				json.put("total",dimissionInfos.size());

				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.write(json.toString());
				out.close();
			} 
		
		else if (reqCode.equals("findDimissionInfoById")) {
			// 获取部门编号
			String stuffID = req.getParameter("stuffID");
			// 调用Model，查询该部门
			DimissionInfoService dimissionInfoService = new DimissionInfoService();
			DimissionInfo dimissionInfo = dimissionInfoService
					.findDimissionInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(dimissionInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateDimissionInfo")) {
			// 提取数据
			// int id = (Integer.parseInt(req.getParameter("id")));

			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			String stuffDuty = req.getParameter("stuffDuty");
			String dimissInterface = req.getParameter("dimissInterface");
			String dimissReason = req.getParameter("dimissReason");
			String dimissDate = req.getParameter("dimissDate");

			DimissionInfo dimissionInfo = new DimissionInfo(stuffID,stuffName,
					stuffDepart, stuffDuty, dimissInterface, dimissReason,
					dimissDate);
			// 调用Model
			DimissionInfoService dimissionInfoService = new DimissionInfoService();
			int result = dimissionInfoService
					.updateDimissionInfo(dimissionInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("离职信息修改成功！");
			} else {
				out.write("离职信息修改失败！");
			}
			out.close();
		} else if (reqCode.equals("addDimissionInfo")) {
			// 要做新增用户操作
			addDimissionInfo(req, resp);
		} else if (reqCode.equals("delDimissionInfo")) {
			delDimissionInfo(req, resp);
		}

	}

	private void addDimissionInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 获取参数
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart = req.getParameter("stuffDepart");
		String stuffDuty = req.getParameter("stuffDuty");
		String dimissInterface = req.getParameter("dimissInterface");
		String dimissReason = req.getParameter("dimissReason");
		String dimissDate = req.getParameter("dimissDate");

		// 将获取的参数封装成User
		DimissionInfo d = new DimissionInfo();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setStuffDuty(stuffDuty);
		d.setDimissInterface(dimissInterface);
		d.setDimissReason(dimissReason);
		d.setDimissDate(dimissDate);

		// 调用Model执行数据处理（插入到数据库）s
		DimissionInfoService dimissionInfoService = new DimissionInfoService();
		int result = dimissionInfoService.addDimissionInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加离职信息成功！");
		} else {
			out.write("增加离职信息失败！");
		}
		out.close();
	}

	private void delDimissionInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 读取参数
		String stuffID = req.getParameter("stuffID");

		// 调用Model，进行删除
		DimissionInfoService dimissionInfoService = new DimissionInfoService();

		int result = dimissionInfoService.delDimissionInfoId(stuffID);
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