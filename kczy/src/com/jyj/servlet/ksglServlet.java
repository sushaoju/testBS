package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


import com.jyj.entity.Ks;
import com.jyj.entity.Patient;

import com.jyj.service.KsService;

public class ksglServlet extends HttpServlet {

	

	

		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String reqCode = request.getParameter("reqCode");
	
	if(reqCode.equals("findAllKss")){
		String pageSize = request.getParameter("rows");
		String pageNo = request.getParameter("page");
		String ksbh = request.getParameter("ksbh");
		KsService ksService=new KsService();
		List<Ks> kss=ksService.findKs(Integer.valueOf(pageSize),Integer.valueOf(pageNo),ksbh);
		int total = ksService.findKssTotalCount(ksbh);
		JSONObject json = new JSONObject();
		json.put("total", total);
		json.put("rows", kss);
		
		//��Model����Ľ�����͵�ǰ̨
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//дshuju
		out.write(json.toString());
		out.close();
		}

		//���û����͵�����
		//req.setAttribute("users", users);
		//������ת����ĳ��������ʾҳ��
		//RequestDispatcher dispatcher=req.getRequestDispatcher("/userlist.jsp");
		//dispatcher.forward(req, resp);
		
	else if(reqCode.equals("findKsById")){
		String id = request.getParameter("id");
		KsService ksService = new KsService();
		Ks ks = ksService.findKsById(id);
		JSONObject json = JSONObject.fromObject(ks);
		//��Model����Ľ�����͵�ǰ̨
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//дshuju
		out.write(json.toString());
		out.close();
	}
	else if(reqCode.equals("updateKs")){
		//��ȡ����
		String id=request.getParameter("id");
		String ksbh=request.getParameter("ksbh");
		String ksmc=request.getParameter("ksmc");
		
		Ks ks=new Ks(Integer.valueOf(id),ksbh,ksmc);
		//����model
		KsService ksService=new KsService();
		int result=ksService.updateKs(ks);
		//��ת���û��б�ҳ�棬չʾ��������
		request.getRequestDispatcher("/ks/ksServlet?reqCode=findAllKss").forward(request, response);
	}
	}

}
