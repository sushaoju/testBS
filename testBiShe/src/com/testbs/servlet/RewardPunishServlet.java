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
		// 获取请求码
		String reqCode = req.getParameter("reqCode");

		if (reqCode.equals("findRewardPunishsForPages")) {
			// 当前页码
			String pageNo = req.getParameter("page");
			int pageNo1 = Integer.valueOf(pageNo);
			// 页面大小
			String pageSize = req.getParameter("rows");
			int pageSize1 = Integer.valueOf(pageSize);
			// 获取查询参数
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
			// 获取部门编号
			String stuffID = req.getParameter("stuffID");
			// 调用Model，查询该部门
			RewardPunishService rewardPunishService = new RewardPunishService();
			RewardPunish rewardPunish = rewardPunishService.findRewardPunishById(stuffID);

			JSONObject json = JSONObject.fromObject(rewardPunish);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if (reqCode.equals("findRewardPunishByCondition")) {
			
			String stuffName = req.getParameter("stuffName"); //姓名
			String stuffID = req.getParameter("stuffID"); // 工号
			String stuffDepart = req.getParameter("stuffDepart"); // 部门
			
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
			// 提取数据
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
			// 调用Model
			RewardPunishService rewardPunishService = new RewardPunishService();
			int result = rewardPunishService.updateRewardPunish(rewardPunish);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("奖惩信息修改成功！");
			} else {
				out.write("奖惩信息修改失败！");
			}
			out.close();
		} else if (reqCode.equals("addRewardPunish")) {
			// 要做新增用户操作
			addRewardPunish(req, resp);
		} else if (reqCode.equals("delRewardPunish")) {
			delRewardPunish(req, resp);
		}

	}

	private void addRewardPunish(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 获取参数
		// int id= (Integer.parseInt(req.getParameter("id")));
		String stuffID1 = req.getParameter("stuffID");
		String stuffName = req.getParameter("stuffName");
		String stuffDepart = req.getParameter("stuffDepart");
		String happenDate = req.getParameter("happenDate");
		String happenType = req.getParameter("happenType");
		String happenReason = req.getParameter("happenReason");
		double changeMoney=(Double.parseDouble(req.getParameter("changeMoney")));

		// 将获取的参数封装成User
		RewardPunish d = new RewardPunish();
		// d.setId(id);
		d.setStuffID(stuffID1);
		d.setStuffName(stuffName);
		d.setStuffDepart(stuffDepart);
		d.setHappenDate(happenDate);
		d.setHappenType(happenType);
		d.setHappenReason(happenReason);
		d.setChangeMoney(changeMoney);

		// 调用Model执行数据处理（插入到数据库）s
		RewardPunishService rewardPunishService = new RewardPunishService();
		int result = rewardPunishService.addRewardPunish(d);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.write("增加奖惩信息成功！");
		} else {
			out.write("增加奖惩信息失败！");
		}
		out.close();
	}

	private void delRewardPunish(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 读取参数
		String stuffID = req.getParameter("stuffID");

		// 调用Model，进行删除
		RewardPunishService rewardPunishService = new RewardPunishService();

		int result = rewardPunishService.delRewardPunishId(stuffID);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if (result > 0) {
			out.write("删除成功！");
		} else {
			out.write("删除失败！");
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
