package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.jyj.entity.XHDrug;
import com.jyj.service.XHDrugService;

public class XHDrugServlet extends HttpServlet {

	
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
			
			XHDrugService xhdrugService =new XHDrugService();
			List<XHDrug> xhdrugs = xhdrugService.getXHDrugsForPage(ypmc,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
			int total = xhdrugService.getTotalCount(ypmc);
			
			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", xhdrugs);
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("findAllXHDrugs")){
			XHDrugService xhdrugService = new XHDrugService();
			List<XHDrug> xhdrugs= xhdrugService.findAllXHDrugs();

			JSONObject json=new JSONObject();
			json.put("rows", xhdrugs);
			json.put("total", xhdrugs.size());
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("findXHDrugById")){
			//��ȡ�û����
			String id = req.getParameter("id");
			//����Model����ѯ���û�
			XHDrugService xhdrugService = new XHDrugService();
			XHDrug xhdrug = xhdrugService.findXHDrugById(id);
			
			JSONObject json=JSONObject.fromObject(xhdrug);
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
