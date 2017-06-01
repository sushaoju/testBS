package com.testbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testbs.entity.RetireInfo;
import com.testbs.service.RetireInfoService;

import net.sf.json.JSONObject;



public class RetireInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RetireInfoServlet() {
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

		if (reqCode.equals("findRetireInfosForPages")) {
			// ��ǰҳ��
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// ҳ���С
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// ��ȡ��ѯ����
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");

			RetireInfoService retireInfoService = new RetireInfoService();
			List<RetireInfo> retireInfos = retireInfoService
					.getRetireInfoForPage(stuffID,stuffName, pageNo1, pageSize1);
			int total = retireInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", retireInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findAllRetireInfos")) {
			RetireInfoService retireInfoService = new RetireInfoService();
			List<RetireInfo> retireInfos = retireInfoService.findAllRetireInfos();

			JSONObject json = new JSONObject();
			json.put("rows", retireInfos);
			json.put("total", retireInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 	 else if (reqCode.equals("findRetireInfoByCondition")) {
			
			String stuffName = req.getParameter("stuffName"); //����
			String stuffID = req.getParameter("stuffID"); // ����
		
			
			RetireInfoService retireInfoService = new RetireInfoService();
			List<RetireInfo> retireInfos = retireInfoService.findRetireInfoByCondition(stuffID,stuffName);
	
			JSONObject json = new JSONObject();
			json.put("rows", retireInfos);
			json.put("total",retireInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
	else if (reqCode.equals("findRetireInfoById")) {
			// ��ȡ���ű��
			String stuffID = req.getParameter("stuffID");
			// ����Model����ѯ�ò���
			RetireInfoService retireInfoService = new RetireInfoService();
			RetireInfo retireInfo = retireInfoService
					.findRetireInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(retireInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateRetireInfo")) {
			// ��ȡ����
			// int id = (Integer.parseInt(req.getParameter("id")));
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			String stuffDuty = req.getParameter("stuffDuty");
			String stuffEntryDate = req.getParameter("stuffEntryDate");
			String retireDate = req.getParameter("retireDate");
			String retireInterface = req.getParameter("retireInterface");
			double retireMoney=(Double.parseDouble(req.getParameter("retireMoney")));

			RetireInfo retireInfo = new RetireInfo(stuffID,stuffName,
					stuffDepart, stuffDuty, stuffEntryDate, retireDate,
					retireInterface,retireMoney);
			// ����Model
			RetireInfoService retireInfoService = new RetireInfoService();
			int result = retireInfoService
					.updateRetireInfo(retireInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("������Ϣ�޸ĳɹ���");
			} else {
				out.write("������Ϣ�޸�ʧ�ܣ�");
			}
			out.close();
		} else if (reqCode.equals("addRetireInfo")) {
			// Ҫ�������û�����
			addRetireInfo(req, resp);
		} else if (reqCode.equals("delRetireInfo")) {
			delRetireInfo(req, resp);
		}

	}

	private void addRetireInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// ��ȡ����
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart = req.getParameter("stuffDepart");
		String stuffDuty = req.getParameter("stuffDuty");
		String stuffEntryDate = req.getParameter("stuffEntryDate");
		String retireDate = req.getParameter("retireDate");
		String retireInterface = req.getParameter("retireInterface");
		double retireMoney=Double.parseDouble(req.getParameter("retireMoney"));

		// ����ȡ�Ĳ�����װ��User
		RetireInfo d = new RetireInfo();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setStuffDuty(stuffDuty);
		d.setStuffEntryDate(stuffEntryDate);
		d.setRetireDate(retireDate);
		d.setRetireInterface(retireInterface);
		d.setRetireMoney(retireMoney);

		// ����Modelִ�����ݴ������뵽���ݿ⣩s
		RetireInfoService retireInfoService = new RetireInfoService();
		int result = retireInfoService.addRetireInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("����������Ϣ�ɹ���");
		} else {
			out.write("����������Ϣʧ�ܣ�");
		}
		out.close();
	}

	private void delRetireInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// ��ȡ����
		String stuffID = req.getParameter("stuffID");

		// ����Model������ɾ��
		RetireInfoService retireInfoService = new RetireInfoService();

		int result = retireInfoService.delRetireInfoId(stuffID);
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