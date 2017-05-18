package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.jyj.entity.HDrug;
import com.jyj.service.HDrugService;

public class HDrugServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    doPost(request, response);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		// 获取请求码
		String reqCode = req.getParameter("reqCode");
		if(reqCode.equals("findDrugsForPages")){
			//当前页码Drugs
			String pageNo = req.getParameter("page");
			//页面大小
			String pageSize= req.getParameter("rows");
			//获取查询参数			
			String ypmc = req.getParameter("ypmc");
			
			HDrugService hdrugService =new HDrugService();
			List<HDrug> hdrugs = hdrugService.getHDrugsForPage(ypmc,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
			int total = hdrugService.getTotalCount(ypmc);
			
			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", hdrugs);
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("findAllHDrugs")){
			HDrugService hdrugService = new HDrugService();
			List<HDrug> hdrugs= hdrugService.findAllHDrugs();

			JSONObject json=new JSONObject();
			json.put("rows", hdrugs);
			json.put("total", hdrugs.size());
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("findHDrugById")){
			//获取用户编号
			String id = req.getParameter("id");
			//调用Model，查询该用户
			HDrugService hdrugService = new HDrugService();
			HDrug hdrug = hdrugService.findHDrugById(id);
			
			JSONObject json=JSONObject.fromObject(hdrug);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
			}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
