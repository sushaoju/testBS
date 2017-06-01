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

import com.testbs.entity.DimissionInfo;

import com.testbs.service.DimissionInfoService;

public class DimissionInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DimissionInfoServlet() {
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
		// ��ȡ������
		String reqCode = req.getParameter("reqCode");

		if (reqCode.equals("findDimissionInfosForPages")) {
			// ��ǰҳ��
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// ҳ���С
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// ��ȡ��ѯ����
			String stuffID = req.getParameter("stuffID");

			DimissionInfoService dimissionInfoService = new DimissionInfoService();
			List<DimissionInfo> dimissionInfos = dimissionInfoService
					.getDimissionInfoForPage(stuffID, pageNo1, pageSize1);
			int total = dimissionInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", dimissionInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}
		else if (reqCode.equals("findAllDimissionInfos")) {
			DimissionInfoService dimissionInfoService = new DimissionInfoService();
			List<DimissionInfo> dimissionInfos = dimissionInfoService
					.findAllDimissionInfos();

			JSONObject json = new JSONObject();
			json.put("rows", dimissionInfos);
			json.put("total", dimissionInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		
		 else if (reqCode.equals("findDimissionInfoByCondition")) {
				
				String stuffName = req.getParameter("stuffName"); //����
				String stuffID = req.getParameter("stuffID"); // ����
				String stuffDepart = req.getParameter("stuffDepart"); // ����
				
				DimissionInfoService dimissionInfoService = new DimissionInfoService();
				List<DimissionInfo> dimissionInfos = dimissionInfoService.findDimissionInfoByCondition(stuffID,stuffName,stuffDepart);
		
				JSONObject json = new JSONObject();
				json.put("rows", dimissionInfos);
				json.put("total",dimissionInfos.size());

				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.write(json.toString());
				out.close();
			} 
		
		else if (reqCode.equals("findDimissionInfoById")) {
			// ��ȡ���ű��
			String stuffID = req.getParameter("stuffID");
			// ����Model����ѯ�ò���
			DimissionInfoService dimissionInfoService = new DimissionInfoService();
			DimissionInfo dimissionInfo = dimissionInfoService
					.findDimissionInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(dimissionInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateDimissionInfo")) {
			// ��ȡ����
			// int id = (Integer.parseInt(req.getParameter("id")));

			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			String stuffDuty = req.getParameter("stuffDuty");
			String dimissInterface = req.getParameter("dimissInterface");
			String dimissReason = req.getParameter("dimissReason");
			String dimissDate = req.getParameter("dimissDate");

			DimissionInfo dimissionInfo = new DimissionInfo(stuffID,stuffName,
					stuffDepart, stuffDuty, dimissInterface, dimissReason,
					dimissDate);
			// ����Model
			DimissionInfoService dimissionInfoService = new DimissionInfoService();
			int result = dimissionInfoService
					.updateDimissionInfo(dimissionInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("��ְ��Ϣ�޸ĳɹ���");
			} else {
				out.write("��ְ��Ϣ�޸�ʧ�ܣ�");
			}
			out.close();
		} else if (reqCode.equals("addDimissionInfo")) {
			// Ҫ�������û�����
			addDimissionInfo(req, resp);
		} else if (reqCode.equals("delDimissionInfo")) {
			delDimissionInfo(req, resp);
		}

	}

	private void addDimissionInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// ��ȡ����
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart = req.getParameter("stuffDepart");
		String stuffDuty = req.getParameter("stuffDuty");
		String dimissInterface = req.getParameter("dimissInterface");
		String dimissReason = req.getParameter("dimissReason");
		String dimissDate = req.getParameter("dimissDate");

		// ����ȡ�Ĳ�����װ��User
		DimissionInfo d = new DimissionInfo();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setStuffDuty(stuffDuty);
		d.setDimissInterface(dimissInterface);
		d.setDimissReason(dimissReason);
		d.setDimissDate(dimissDate);

		// ����Modelִ�����ݴ������뵽���ݿ⣩s
		DimissionInfoService dimissionInfoService = new DimissionInfoService();
		int result = dimissionInfoService.addDimissionInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("������ְ��Ϣ�ɹ���");
		} else {
			out.write("������ְ��Ϣʧ�ܣ�");
		}
		out.close();
	}

	private void delDimissionInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// ��ȡ����
		String stuffID = req.getParameter("stuffID");

		// ����Model������ɾ��
		DimissionInfoService dimissionInfoService = new DimissionInfoService();

		int result = dimissionInfoService.delDimissionInfoId(stuffID);
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