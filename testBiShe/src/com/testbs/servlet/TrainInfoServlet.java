package com.testbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testbs.entity.DimissionInfo;
import com.testbs.entity.TrainInfo;
import com.testbs.service.DimissionInfoService;
import com.testbs.service.TrainInfoService;

import net.sf.json.JSONObject;



public class TrainInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TrainInfoServlet() {
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

		if (reqCode.equals("findTrainInfosForPages")) {
			// ��ǰҳ��
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// ҳ���С
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// ��ȡ��ѯ����
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");

			TrainInfoService trainInfoService = new TrainInfoService();
			List<TrainInfo> trainInfos = trainInfoService.getTrainInfoForPage(
					stuffID,stuffName, pageNo1, pageSize1);
			int total = trainInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", trainInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findAllTrainInfos")) {
			TrainInfoService trainInfoService = new TrainInfoService();
			List<TrainInfo> trainInfos = trainInfoService.findAllTrainInfos();

			JSONObject json = new JSONObject();
			json.put("rows", trainInfos);
			json.put("total", trainInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		
		else if (reqCode.equals("findTrainInfoByCondition")) {
			
			String stuffName = req.getParameter("stuffName"); //����
			String stuffID = req.getParameter("stuffID"); // ����
			String stuffDepart = req.getParameter("stuffDepart"); // ����
			
			TrainInfoService trainInfoService = new TrainInfoService();
			List<TrainInfo> trainInfos = trainInfoService.findTrainInfoByCondition(stuffID,stuffName,stuffDepart);
	
			JSONObject json = new JSONObject();
			json.put("rows", trainInfos);
			json.put("total",trainInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		
		else if (reqCode.equals("findTrainInfoById")) {
			// ��ȡ���ű��
			String stuffID = req.getParameter("stuffID");
			// ����Model����ѯ�ò���
			TrainInfoService trainInfoService = new TrainInfoService();
			TrainInfo trainInfo = trainInfoService.findTrainInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(trainInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("updateTrainInfo")) {
			// ��ȡ����
			// int id = (Integer.parseInt(req.getParameter("id")));
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			String trainType = req.getParameter("trainType");
			String trainBegin = req.getParameter("trainBegin");
			String trainEnd = req.getParameter("trainEnd");
			String trainTeacher = req.getParameter("trainTeacher");
			String trainResult = req.getParameter("trainResult");

			TrainInfo trainInfo = new TrainInfo(stuffID,stuffName, stuffDepart, trainType,
					trainBegin,trainEnd,trainTeacher,trainResult);
			// ����Model
			TrainInfoService trainInfoService = new TrainInfoService();
			int result = trainInfoService.updateTrainInfo(trainInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("��ѵ��Ϣ�޸ĳɹ���");
			} else {
				out.write("��ѵ��Ϣ�޸�ʧ�ܣ�");
			}
			out.close();
		} else if (reqCode.equals("addTrainInfo")) {
			// Ҫ�������û�����
			addTrainInfo(req, resp);
		} else if (reqCode.equals("delTrainInfo")) {
			delTrainInfo(req, resp);
		}

	}

	private void addTrainInfo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// ��ȡ����
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart = req.getParameter("stuffDepart");
		String trainType = req.getParameter("trainType");
		String trainBegin = req.getParameter("trainBegin");
		String trainEnd = req.getParameter("trainEnd");
		String trainTeacher = req.getParameter("trainTeacher");
		String trainResult = req.getParameter("trainResult");
		

		// ����ȡ�Ĳ�����װ��User
		TrainInfo d = new TrainInfo();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setTrainType(trainType);
		d.setTrainBegin(trainBegin);
		d.setTrainEnd(trainEnd);
		d.setTrainTeacher(trainTeacher);
		d.setTrainResult(trainResult);

		// ����Modelִ�����ݴ������뵽���ݿ⣩s
		TrainInfoService trainInfoService = new TrainInfoService();
		int result = trainInfoService.addTrainInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("������ѵ��Ϣ�ɹ���");
		} else {
			out.write("������ѵ��Ϣʧ�ܣ�");
		}
		out.close();
	}

	private void delTrainInfo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// ��ȡ����
		String stuffID = req.getParameter("stuffID");

		// ����Model������ɾ��
		TrainInfoService trainInfoService = new TrainInfoService();

		int result = trainInfoService.delTrainInfoId(stuffID);
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
