package com.testbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.testbs.entity.SalaryInfo;

import com.testbs.service.SalaryInfoService;

import net.sf.json.JSONObject;


public class SalaryInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SalaryInfoServlet() {
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

		if (reqCode.equals("findSalaryInfosForPages")) {
			// ��ǰҳ��
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// ҳ���С
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// ��ȡ��ѯ����
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");

			SalaryInfoService salaryInfoService = new SalaryInfoService();
			List<SalaryInfo> adminInfos = salaryInfoService.getSalaryInfoForPage(
					stuffID,stuffName, pageNo1, pageSize1);
			int total = salaryInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", adminInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findAllSalaryInfos")) {
			SalaryInfoService salaryInfoService = new SalaryInfoService();
			List<SalaryInfo> salaryInfos = salaryInfoService.findAllSalaryInfos();

			JSONObject json = new JSONObject();
			json.put("rows", salaryInfos);
			json.put("total", salaryInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findSalaryInfoByCondition")) {
			
			String stuffName = req.getParameter("stuffName"); //����
			String stuffID = req.getParameter("stuffID"); // ����
			String stuffDepart = req.getParameter("stuffDepart"); // ����
			
			SalaryInfoService salaryInfoService = new SalaryInfoService();
			List<SalaryInfo> salaryInfos = salaryInfoService.findSalaryInfoByCondition(stuffID,stuffName,stuffDepart);
	
			JSONObject json = new JSONObject();
			json.put("rows", salaryInfos);
			json.put("total",salaryInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findSalaryInfoById")) {
			// ��ȡ���ű��
			String stuffID = req.getParameter("stuffID");
			// ����Model����ѯ�ò���
			SalaryInfoService salaryInfoService = new SalaryInfoService();
			SalaryInfo salaryInfo = salaryInfoService.findSalaryInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(salaryInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateSalaryInfo")) {
			// ��ȡ����
			// int id = (Integer.parseInt(req.getParameter("id")));
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			String stuffDuty = req.getParameter("stuffDuty");
			double basicSalary=(Double.parseDouble(req.getParameter("basicSalary")));
			double delSalary=(Double.parseDouble(req.getParameter("delSalary")));
			double addSalary=(Double.parseDouble(req.getParameter("addSalary")));
			double accountAwce=(Double.parseDouble(req.getParameter("accountAwce")));
			double fSalary=(Double.parseDouble(req.getParameter("fSalary")));

			SalaryInfo salaryInfo = new SalaryInfo(stuffID,stuffName, stuffDepart, stuffDuty,
					basicSalary,delSalary,addSalary,accountAwce,fSalary);
			// ����Model
			SalaryInfoService salaryInfoService = new SalaryInfoService();
			int result = salaryInfoService.updateSalaryInfo(salaryInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("н����Ϣ�޸ĳɹ���");
			} else {
				out.write("н����Ϣ�޸�ʧ�ܣ�");
			}
			out.close();
		} else if (reqCode.equals("addSalaryInfo")) {
			// Ҫ�������û�����
			addSalaryInfo(req, resp);
		} else if (reqCode.equals("delSalaryInfo")) {
			delSalaryInfo(req, resp);
		}

	}

	private void addSalaryInfo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// ��ȡ����
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart = req.getParameter("stuffDepart");
		String stuffDuty = req.getParameter("stuffDuty");
		double basicSalary=(Double.parseDouble(req.getParameter("basicSalary")));
		double delSalary=(Double.parseDouble(req.getParameter("delSalary")));
		double addSalary=(Double.parseDouble(req.getParameter("addSalary")));
		double fSalary=(Double.parseDouble(req.getParameter("fSalary")));
	

		// ����ȡ�Ĳ�����װ��User
		SalaryInfo d = new SalaryInfo();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setStuffDuty(stuffDuty);
		d.setBasicSalary(basicSalary);
		d.setDelSalary(delSalary);
		d.setAddSalary(addSalary);
		d.setfSalary(fSalary);

		// ����Modelִ�����ݴ������뵽���ݿ⣩s
		SalaryInfoService salaryInfoService = new SalaryInfoService();
		int result = salaryInfoService.addSalaryInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("����н����Ϣ�ɹ���");
		} else {
			out.write("����н����Ϣʧ�ܣ�");
		}
		out.close();
	}

	private void delSalaryInfo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// ��ȡ����
		String stuffID = req.getParameter("stuffID");

		// ����Model������ɾ��
		SalaryInfoService salaryInfoService = new SalaryInfoService();

		int result = salaryInfoService.delSalaryInfoId(stuffID);
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