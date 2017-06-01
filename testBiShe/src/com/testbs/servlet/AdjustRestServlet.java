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

import com.testbs.entity.AdjustRestInfo;
import com.testbs.entity.TrainInfo;

import com.testbs.service.AdjustRestInfoService;
import com.testbs.service.TrainInfoService;


public class AdjustRestServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdjustRestServlet() {
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

		if (reqCode.equals("findAdjustRestInfosForPages")) {
			// ��ǰҳ��
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// ҳ���С
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// ��ȡ��ѯ����
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");

			AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
			List<AdjustRestInfo> adjustrestInfos = adjustrestInfoService
					.getAdjustRestInfoForPage(stuffID,stuffName, pageNo1, pageSize1);
			int total = adjustrestInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", adjustrestInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		else if (reqCode.equals("findAllAdjustRestInfos")) {
			AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
			List<AdjustRestInfo> adjustrestInfos = adjustrestInfoService.findAllAdjustRestInfos();

			JSONObject json = new JSONObject();
			json.put("rows", adjustrestInfos);
			json.put("total", adjustrestInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		
else if (reqCode.equals("findAdjustRestInfoByCondition")) {
			
			String stuffName = req.getParameter("stuffName"); //����
			String stuffID = req.getParameter("stuffID"); // ����
			String stuffDepart = req.getParameter("stuffDepart"); // ����
			
			AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
			List<AdjustRestInfo> adjustrestInfos = adjustrestInfoService.findAdjustRestInfoByCondition(stuffID,stuffName,stuffDepart);
	
			JSONObject json = new JSONObject();
			json.put("rows", adjustrestInfos);
			json.put("total",adjustrestInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		
		else if (reqCode.equals("findAdjustRestInfoById")) {
			// ��ȡ���ű��
			String stuffID = req.getParameter("stuffID");
			// ����Model����ѯ�ò���
			AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
			AdjustRestInfo adjustrestInfo = adjustrestInfoService.findAdjustRestInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(adjustrestInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateAdjustRestInfo")) {
			// ��ȡ����
//			int id = (Integer.parseInt(req.getParameter("id")));
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			String adjustType = req.getParameter("adjustType");
			String adjustBefore = req.getParameter("adjustBefore");
			String adjustAfter = req.getParameter("adjustAfter");
			String adjustApprover = req.getParameter("adjustApprover");

		
			//entity��Ҫ����Ӧ�Ĳ������
			AdjustRestInfo adjustrestInfo = new AdjustRestInfo(stuffID,stuffName,
					stuffDepart, adjustType,adjustBefore,adjustAfter,adjustApprover);
			// ����Model
			AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
			int result = adjustrestInfoService
					.updateAdjustRestInfo(adjustrestInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("�����޸ĳɹ���");
			} else {
				out.write("�����޸�ʧ�ܣ�");
			}
			out.close();
		}
		else if (reqCode.equals("addAdjustRestInfo")) {
			// Ҫ�������û�����
			addAdjustRestInfo(req, resp);
		} else if (reqCode.equals("delAdjustRestInfo")) {
			delAdjustRestInfo(req, resp);
		}

	}

	private void addAdjustRestInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// ��ȡ����
		//int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart=req.getParameter("stuffDepart");
		String adjustType = req.getParameter("adjustType");
		String adjustBefore = req.getParameter("adjustBefore");
		String adjustAfter = req.getParameter("adjustAfter");
		String adjustApprover=req.getParameter("adjustApprover");
		
		// ����ȡ�Ĳ�����װ��User
		AdjustRestInfo d = new AdjustRestInfo();
		//d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setAdjustType(adjustType);
		d.setAdjustBefore(adjustBefore);
		d.setAdjustAfter(adjustAfter);
		d.setAdjustApprover(adjustApprover);

		// ����Modelִ�����ݴ������뵽���ݿ⣩s
		AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
		int result = adjustrestInfoService.addAdjustRestInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("���ӵ�����Ϣ�ɹ���");
		} else {
			out.write("���ӵ�����Ϣʧ�ܣ�");
		}
		out.close();
	}

	private void delAdjustRestInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// ��ȡ����
		String stuffID = req.getParameter("stuffID");

		// ����Model������ɾ��
		AdjustRestInfoService adjustrestInfoService = new AdjustRestInfoService();
		
		int result = adjustrestInfoService.delAdjustRestInfoId(stuffID);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if (result > 0) {
			out.write("ɾ���ɹ���");
		} else {
			out.write("ɾ��ʧ�ܣ�");
		}
		out.close();
	}
	
	//�����ַ��� ת���� ����
//	private Date dateFormat(String dateStr) throws ParseException {
//		Date date=new Date();
//		try{
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		    date = sdf.parse(dateStr);
//			
//		}catch(ParseException e){
//			System.out.println(e.getMessage());
//		}
//		return date;
//	}
	
	
	
	
	
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

