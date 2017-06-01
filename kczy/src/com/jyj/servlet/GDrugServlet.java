package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.jyj.entity.GDrug;
import com.jyj.service.GDrugService;

public class GDrugServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		// ��ȡ������
		String reqCode = req.getParameter("reqCode");
		if(reqCode.equals("findDrugsForPages")){
			//��ǰҳ��Drugs
			String pageNo = req.getParameter("page");
			//ҳ���С
			String pageSize= req.getParameter("rows");
			//��ȡ��ѯ����			
			String ypmc = req.getParameter("ypmc");
			
			GDrugService gdrugService =new GDrugService();
			List<GDrug> gdrugs = gdrugService.getGDrugsForPage(ypmc,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
			int total = gdrugService.getTotalCount(ypmc);
			
			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", gdrugs);
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("findAllGDrugs")){
			GDrugService gdrugService = new GDrugService();
			List<GDrug> gdrugs= gdrugService.findAllGDrugs();

			JSONArray array=JSONArray.fromObject(gdrugs) ;
		
//			JSONObject json=new JSONObject();
//			json.put("rows", gdrugs);
//			json.put("total", gdrugs.size());
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
//			out.write(json.toString());
			out.write(array.toString());
			out.close();
			System.out.println(array.toString());
			
			
		}else if(reqCode.equals("findGDrugById")){
			//��ȡ�û����
			String id = req.getParameter("id");
			//����Model����ѯ���û�
			GDrugService gdrugService = new GDrugService();
			GDrug gdrug = gdrugService.findGDrugById(id);
			
			JSONObject json=JSONObject.fromObject(gdrug);
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
