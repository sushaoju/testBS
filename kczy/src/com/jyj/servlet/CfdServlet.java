package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jyj.entity.Cfd;
import com.jyj.entity.Ghd;
import com.jyj.service.CfdService;
import com.jyj.service.GhglService;

public class CfdServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CfdServlet() {
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
		if(reqCode.equals("addcfd")){
			//做新增用户操作
			    String d_id = request.getParameter("d_id");
				String p_account = request.getParameter("p_account");
				
				String ypmc=request.getParameter("ypmc");
				String ypsl = request.getParameter("ypsl");
				String zje = request.getParameter("zje");
				
				
				// 将获取的参数封装成User
				Cfd cfd = new Cfd();
				cfd.setD_id(d_id);
				cfd.setP_account(p_account);
				cfd.setYpmc(ypmc);
				cfd.setYpsl(ypsl);
				cfd.setZje(zje);
				CfdService cfdService = new CfdService();
				int result = cfdService.addCfd(cfd);

				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();

				if (result > 0) {
					out.write("处方单生成成功！");
				} else {
					out.write("处方单生成失败！");
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
