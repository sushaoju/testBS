package com.testbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


import com.testbs.entity.JobInfo;
import com.testbs.service.JobInfoService;

public class JobInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public JobInfoServlet() {
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

		if (reqCode.equals("findJobInfosForPages")) {
			// ��ǰҳ��
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// ҳ���С
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// ��ȡ��ѯ����
			String stuffID = req.getParameter("stuffID");

			JobInfoService jobInfoService = new JobInfoService();
			List<JobInfo> jobInfos = jobInfoService.getJobInfoForPage(stuffID, pageNo1, pageSize1);
			int total = jobInfoService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", jobInfos);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		else if (reqCode.equals("findAllJobInfos")) {
			JobInfoService jobInfoService = new JobInfoService();
			List<JobInfo> jobInfos  = jobInfoService.findAllJobInfos();

			JSONObject json = new JSONObject();
			json.put("rows", jobInfos);
			json.put("total", jobInfos.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
			
		} 
		else if (reqCode.equals("findJobInfoById")) {
			// ��ȡ���ű��
			String stuffID = req.getParameter("stuffID");
			// ����Model����ѯ�ò���
			JobInfoService jobInfoService = new JobInfoService();
			JobInfo jobInfo = jobInfoService.findJobInfoById(stuffID);

			JSONObject json = JSONObject.fromObject(jobInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} 
		else if (reqCode.equals("updateJobInfo")) {
			// ��ȡ����
//			int id = (Integer.parseInt(req.getParameter("id")));
			String stuffID = req.getParameter("stuffID");
			String adjustMoney = req.getParameter("adjustMoney");  
			String adjustJob = req.getParameter("adjustJob");     
			
			JobInfo jobInfo = new JobInfo( stuffID,adjustJob,adjustMoney);
			// ����Model
			
			JobInfoService jobInfoService = new JobInfoService();
			int result = jobInfoService.updateJobInfo(jobInfo);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("��λ��Ϣ�޸ĳɹ���");
			} else {
				out.write("��λ��Ϣ�޸�ʧ�ܣ�");
			}
			out.close();
		}
		else if (reqCode.equals("addJobInfo")) {
			// Ҫ�������û�����
			addJobInfo(req, resp);
		} else if (reqCode.equals("delJobInfo")) {
			delJobInfo(req, resp);
		}

	}

	private void addJobInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// ��ȡ����
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart = req.getParameter("stuffDepart");
		String stuffDuty = req.getParameter("stuffDuty");
		String stuffStatus = req.getParameter("stuffStatus");
		String stuffEntryDate = req.getParameter("stuffEntryDate");
		Double stuffMoney = Double.parseDouble(req.getParameter("stuffMoney"));
		String contractBegin = req.getParameter("contractBegin");
		String contractEnd = req.getParameter("contractEnd");     
		String adjustMoney = req.getParameter("adjustMoney");   
		String adjustJob = req.getParameter("adjustJob");   
		
		
		// ����ȡ�Ĳ�����װ��User
		JobInfo d = new JobInfo();
		// d.setId(id);
		d.setStuffID(stuffID);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setStuffDuty(stuffDuty);
		d.setStuffStatus(stuffStatus);
		d.setStuffEntryDate(stuffEntryDate);
		d.setContractBegin(contractBegin);
		d.setContractEnd(contractEnd);
		d.setStuffMoney(stuffMoney);
		d.setAdjustMoney(adjustMoney);
		d.setAdjustJob(adjustJob);
		

		// ����Modelִ�����ݴ������뵽���ݿ⣩s
		JobInfoService jobInfoService = new JobInfoService();
		int result = jobInfoService.addJobInfo(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("���Ӹ�λ��Ϣ�ɹ���");
		} else {
			out.write("���Ӹ�λ��Ϣʧ�ܣ�");
		}
		out.close();
	}

	private void delJobInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// ��ȡ����
		String stuffID = req.getParameter("stuffID");

		// ����Model������ɾ��
		JobInfoService jobInfoService = new JobInfoService();
		
		int result = jobInfoService.delJobInfoId(stuffID);
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
		private Date dateFormat(String dateStr) throws ParseException {
			Date date=new Date();
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    date = sdf.parse(dateStr);
				
			}catch(ParseException e){
				System.out.println(e.getMessage());
			}
			return date;
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
