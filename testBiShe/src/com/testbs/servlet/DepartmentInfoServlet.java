package com.testbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.testbs.entity.DepartmentInfo;
import com.testbs.service.DepartmentInfoService;

public class DepartmentInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DepartmentInfoServlet() {
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

		if (reqCode.equals("findDepartmentInfosForPages")) {
			// 当前页码
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// 页面大小
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// 获取查询参数
			String departID = req.getParameter("departID");

			DepartmentInfoService departmentInfoService = new DepartmentInfoService();
			List<DepartmentInfo> departmentInfos = departmentInfoService
					.getDepartmentInfoForPage(departID, pageNo1, pageSize1);
			int total = departmentInfoService.getTotalCount(departID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", departmentInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		else if (reqCode.equals("findAllDepartmentInfos")) {
			DepartmentInfoService departmentInfoService = new DepartmentInfoService();
			List<DepartmentInfo> departmentInfos = departmentInfoService.findAllDepartmentInfos();

			JSONObject json = new JSONObject();
			json.put("rows", departmentInfos);
			json.put("total", departmentInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findDepartmentInfoById")) {
			// 获取部门编号
			String departID = req.getParameter("departID");
			// 调用Model，查询该部门
			DepartmentInfoService departmentInfoService = new DepartmentInfoService();
			DepartmentInfo departmentInfo = departmentInfoService.findDepartmentInfoById(departID);

			JSONObject json = JSONObject.fromObject(departmentInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateDepartmentInfo")) {
			// 提取数据
//			int id = (Integer.parseInt(req.getParameter("id")));
			String departID1 = req.getParameter("departID");
			String departName = req.getParameter("departName");
			String departPrince = req.getParameter("departPrince");

			DepartmentInfo departmentInfo = new DepartmentInfo( departID1,
					departName, departPrince);
			// 调用Model
			DepartmentInfoService departmentInfoService = new DepartmentInfoService();
			int result = departmentInfoService.updateDepartmentInfo(departmentInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("部门修改成功！");
			} else {
				out.write("部门修改失败！");
			}
			out.close();
		}
		else if (reqCode.equals("addDepartmentInfo")) {
			// 要做新增用户操作
			addDepartmentInfo(req, resp);
		} else if (reqCode.equals("delDepartmentInfo")) {
			delDepartmentInfo(req, resp);
		}

	}

	private void addDepartmentInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 获取参数
		// int id= (Integer.parseInt(req.getParameter("id")));
		String departID1 = req.getParameter("departID");
		String departName = req.getParameter("departName");
		String departPrince = req.getParameter("departPrince");

		// 将获取的参数封装成User
		DepartmentInfo d = new DepartmentInfo();
		// d.setId(id);
		d.setDepartID(departID1);
		d.setDepartName(departName);
		d.setDepartPrince(departPrince);

		// 调用Model执行数据处理（插入到数据库）s
		DepartmentInfoService departmentInfoService = new DepartmentInfoService();
		int result = departmentInfoService.addDepartmentInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加部门成功！");
		} else {
			out.write("增加部门失败！");
		}
		out.close();
	}

	private void delDepartmentInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 读取参数
		String departID = req.getParameter("departID");

		// 调用Model，进行删除
		DepartmentInfoService departmentInfoService = new DepartmentInfoService();
		
		int result = departmentInfoService.delDepartmentInfoId(departID);
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
