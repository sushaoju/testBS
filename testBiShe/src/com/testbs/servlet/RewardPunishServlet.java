package com.testbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testbs.entity.RewardPunish;
import com.testbs.service.RewardPunishService;

import net.sf.json.JSONObject;



public class RewardPunishServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RewardPunishServlet() {
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

		if (reqCode.equals("findRewardPunishsForPages")) {
			// ��ǰҳ��
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// ҳ���С
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// ��ȡ��ѯ����
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");

			RewardPunishService rewardPunishService = new RewardPunishService();
			List<RewardPunish> rewardPunishs = rewardPunishService.getRewardPunishForPage(
					stuffID,stuffName, pageNo1, pageSize1);
			int total = rewardPunishService.getTotalCount(stuffID);

			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", rewardPunishs);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findAllRewardPunishs")) {
			RewardPunishService rewardPunishService = new RewardPunishService();
			List<RewardPunish> rewardPunishs = rewardPunishService.findAllRewardPunishs();

			JSONObject json = new JSONObject();
			json.put("rows", rewardPunishs);
			json.put("total", rewardPunishs.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		} else if (reqCode.equals("findRewardPunishById")) {
			// ��ȡ���ű��
			String stuffID = req.getParameter("stuffID");
			// ����Model����ѯ�ò���
			RewardPunishService rewardPunishService = new RewardPunishService();
			RewardPunish rewardPunish = rewardPunishService.findRewardPunishById(stuffID);

			JSONObject json = JSONObject.fromObject(rewardPunish);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if (reqCode.equals("findRewardPunishByCondition")) {
			
			String stuffName = req.getParameter("stuffName"); //����
			String stuffID = req.getParameter("stuffID"); // ����
			String stuffDepart = req.getParameter("stuffDepart"); // ����
			
			RewardPunishService rewardPunishService = new RewardPunishService();
			List<RewardPunish> rewardPunishs = rewardPunishService.findRewardPunishByCondition(stuffID,stuffName,stuffDepart);
	
			JSONObject json = new JSONObject();
			json.put("rows", rewardPunishs);
			json.put("total",rewardPunishs.size());

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}  else if (reqCode.equals("updateRewardPunish")) {
			// ��ȡ����
			// int id = (Integer.parseInt(req.getParameter("id")));
			String stuffID = req.getParameter("stuffID");
			String stuffName = req.getParameter("stuffName");
			String stuffDepart = req.getParameter("stuffDepart");
			String happenDate = req.getParameter("happenDate");
			String happenType = req.getParameter("happenType");
			String happenReason = req.getParameter("happenReason");
			double changeMoney=(Double.parseDouble(req.getParameter("changeMoney")));

			RewardPunish rewardPunish = new RewardPunish(stuffID,stuffName, stuffDepart, happenDate,
					happenType,happenReason,changeMoney);
			// ����Model
			RewardPunishService rewardPunishService = new RewardPunishService();
			int result = rewardPunishService.updateRewardPunish(rewardPunish);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("������Ϣ�޸ĳɹ���");
			} else {
				out.write("������Ϣ�޸�ʧ�ܣ�");
			}
			out.close();
		} else if (reqCode.equals("addRewardPunish")) {
			// Ҫ�������û�����
			addRewardPunish(req, resp);
		} else if (reqCode.equals("delRewardPunish")) {
			delRewardPunish(req, resp);
		}

	}

	private void addRewardPunish(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// ��ȡ����
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart = req.getParameter("stuffDepart");
		String happenDate = req.getParameter("happenDate");
		String happenType = req.getParameter("happenType");
		String happenReason = req.getParameter("happenReason");
		double changeMoney=(Double.parseDouble(req.getParameter("changeMoney")));

		// ����ȡ�Ĳ�����װ��User
		RewardPunish d = new RewardPunish();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setHappenDate(happenDate);
		d.setHappenType(happenType);
		d.setHappenReason(happenReason);
		d.setChangeMoney(changeMoney);

		// ����Modelִ�����ݴ������뵽���ݿ⣩s
		RewardPunishService rewardPunishService = new RewardPunishService();
		int result = rewardPunishService.addRewardPunish(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("���ӽ�����Ϣ�ɹ���");
		} else {
			out.write("���ӽ�����Ϣʧ�ܣ�");
		}
		out.close();
	}

	private void delRewardPunish(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// ��ȡ����
		String stuffID = req.getParameter("stuffID");

		// ����Model������ɾ��
		RewardPunishService rewardPunishService = new RewardPunishService();

		int result = rewardPunishService.delRewardPunishId(stuffID);
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
