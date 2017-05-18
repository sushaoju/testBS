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

import com.jyj.entity.BDrug;
import com.jyj.service.BDrugService;

public class BDrugServlet extends HttpServlet {

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
			
			BDrugService bdrugService =new BDrugService();
			List<BDrug> bdrugs = bdrugService.getBDrugsForPage(ypmc,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
			int total = bdrugService.getTotalCount(ypmc);
			
			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", bdrugs);
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("findAllBDrugs")){
			BDrugService bdrugService = new BDrugService();
			List<BDrug> bdrugs= bdrugService.findAllBDrugs();

			JSONArray array=JSONArray.fromObject(bdrugs) ;
			//json.put("rows", bdrugs);
			//json.put("total", bdrugs.size());
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(array.toString());
			out.close();
		}else if(reqCode.equals("findBDrugById")){
			//��ȡ�û����
			String id = req.getParameter("id");
			//����Model����ѯ���û�
			BDrugService bdrugService = new BDrugService();
			BDrug bdrug = bdrugService.findBDrugById(id);
			
			JSONObject json=JSONObject.fromObject(bdrug);
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
