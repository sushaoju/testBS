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


import com.testbs.entity.allowance;

import com.testbs.service.AllowanceService;

public class AllowanceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AllowanceServlet() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
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
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		// ��ȡ������
		String reqCode = req.getParameter("reqCode");

		if (reqCode.equals("findAllowanceInfosForPages")) {
			// ��ǰҳ��
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// ҳ���С
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// ��ȡ��ѯ����
			String stuffID = req.getParameter("stuffID");

			AllowanceService allowanceService = new AllowanceService();
			List<allowance> allowanceInfos = allowanceService.getAllowanceForPage(stuffID, pageNo1, pageSize1);
			int total = allowanceService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", allowanceInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		else if (reqCode.equals("findAllAllowanceInfos")) {
			AllowanceService allowanceService = new AllowanceService();
			List<allowance> allowanceInfos = allowanceService.findAllAllowanceInfos();

			JSONObject json = new JSONObject();
			json.put("rows", allowanceInfos);
			json.put("total", allowanceInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findAllowanceInfoById")) {
			// ��ȡ���ű��
			String stuffID = req.getParameter("stuffID");
			// ����Model����ѯ�ò���
			AllowanceService allowanceService = new AllowanceService();
			allowance allowanceInfo = allowanceService.findAllowanceInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(allowanceInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateAllowance")) {
			// ��ȡ����
//			int id = (Integer.parseInt(req.getParameter("id")));
			
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			
			int allowanceMonth=(Integer.parseInt(req.getParameter("allowanceMonth")));
			double transAwce=(Double.parseDouble(req.getParameter("transAwce")));
			double foodAwce=(Double.parseDouble(req.getParameter("foodAwce")));
			double houseAwce=(Double.parseDouble(req.getParameter("houseAwce")));
			double cmuAwce=(Double.parseDouble(req.getParameter("cmuAwce")));

			
			
			//entity��Ҫ����Ӧ�Ĳ������
			allowance allowanceInfo = new allowance(stuffName,
					stuffDepart, allowanceMonth,transAwce,foodAwce,houseAwce,cmuAwce);
			// ����Model
			AllowanceService allowanceService = new AllowanceService();
			int result = allowanceService
					.updateAllowance(allowanceInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("�����޸ĳɹ���");
			} else {
				out.write("�����޸�ʧ�ܣ�");
			}
			out.close();
		}
		else if (reqCode.equals("addAllowance")) {
			// Ҫ�������û�����
			addAllowance(req, resp);
		} else if (reqCode.equals("delAllowance")) {
			delAllowance(req, resp);
		}

	}

	private void addAllowance(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// ��ȡ����
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart=req.getParameter("stuffDepart");
		int allowanceMonth=(Integer.parseInt(req.getParameter("allowanceMonth")));
		double transAwce=(Double.parseDouble(req.getParameter("transAwce")));
		double foodAwce=(Double.parseDouble(req.getParameter("foodAwce")));
		double houseAwce=(Double.parseDouble(req.getParameter("houseAwce")));
		double cmuAwce=(Double.parseDouble(req.getParameter("cmuAwce")));
		
		
		// ����ȡ�Ĳ�����װ��User
		allowance d = new allowance();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setAllowanceMonth(allowanceMonth);
		d.setTransAwce(transAwce);
		d.setFoodAwce(foodAwce);
		d.setHouseAwce(houseAwce);
		d.setCmuAwce(cmuAwce);

		// ����Modelִ�����ݴ������뵽���ݿ⣩s
		AllowanceService allowanceService = new AllowanceService();
		int result = allowanceService.addAllowance(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("���Ӳ�����Ϣ�ɹ���");
		} else {
			out.write("���Ӳ�����Ϣʧ�ܣ�");
		}
		out.close();
	}

	private void delAllowance(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// ��ȡ����
		String stuffID = req.getParameter("stuffID");

		// ����Model������ɾ��
		AllowanceService allowanceService = new AllowanceService();
		
		int result = allowanceService.delAllowanceId(stuffID);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if (result > 0) {
			out.write("ɾ���ɹ���");
		} else {
			out.write("ɾ��ʧ�ܣ�");
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

