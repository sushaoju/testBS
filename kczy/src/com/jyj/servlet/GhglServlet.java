package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;



import com.jyj.entity.Ghd;
import com.jyj.entity.Ks;
import com.jyj.entity.Ys;
import com.jyj.service.GhglService;
import com.jyj.service.KsService;
import com.jyj.service.YsService;



public class GhglServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GhglServlet() {
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
		if(reqCode.equals("findAllGhd")){
			String pageSize = request.getParameter("rows");
			String pageNo = request.getParameter("page");
			String g_id = request.getParameter("g_id");
			GhglService ghglService=new GhglService();
			List<Ghd> ghds=ghglService.findGhds(Integer.valueOf(pageSize),Integer.valueOf(pageNo),g_id);
			int total = ghglService.findGhdsTotalCount(g_id);
			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", ghds);
			
			//将Model处理的结果发送到前台
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			//写shuju
			out.write(json.toString());
			out.close();
		}
		
			//做新增用户操作
		else if(reqCode.equals("addghd")){
				//做新增用户操作
					
					String p_account = request.getParameter("p_account");
					String p_age = request.getParameter("p_age");
					String p_sex=request.getParameter("p_sex");
					String p_address = request.getParameter("p_address");
					String d_name = request.getParameter("d_name");
					String szks = request.getParameter("szks");
					String szyy=request.getParameter("szyy");
					
					
					// 将获取的参数封装成User
					Ghd ghd = new Ghd();
					ghd.setP_account(p_account);
					ghd.setP_age(p_age);
					ghd.setP_sex(p_sex);
					ghd.setP_address(p_address);
					ghd.setD_name(d_name);
					ghd.setSzks(szks);
					ghd.setSzyy(szyy);
					
					
					

					GhglService ghglService = new GhglService();
					int result = ghglService.addGhd(ghd);

					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();

					if (result > 0) {
						out.write("挂号成功！");
					} else {
						out.write("挂号失败！");
					}
					out.close();
				}
		}
	
		/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
		public void init() throws ServletException {
			// Put your code here
		}

	}