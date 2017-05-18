package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.jyj.entity.WDrug;
import com.jyj.service.WDrugService;

public class WDrugServlet extends HttpServlet {

	
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
			
			WDrugService wdrugService =new WDrugService();
			List<WDrug> wdrugs = wdrugService.getWDrugsForPage(ypmc,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
			int total = wdrugService.getTotalCount(ypmc);
			
			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", wdrugs);
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("findAllWDrugs")){
			WDrugService wdrugService = new WDrugService();
			List<WDrug> wdrugs= wdrugService.findAllWDrugs();

			JSONObject json=new JSONObject();
			json.put("rows", wdrugs);
			json.put("total", wdrugs.size());
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("findWDrugById")){
			//获取用户编号
			String id = req.getParameter("id");
			//调用Model，查询该用户
			WDrugService wdrugService = new WDrugService();
			WDrug wdrug = wdrugService.findWDrugById(id);
			
			JSONObject json=JSONObject.fromObject(wdrug);
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
