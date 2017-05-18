package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;




import com.jyj.entity.Ks;
import com.jyj.entity.Ys;
import com.jyj.service.YsService;

public class YsglServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public YsglServlet() {
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

		if(reqCode.equals("findysByKsbh")){
			String pageSize = request.getParameter("rows");
			String pageNo = request.getParameter("page");
			String ksbh = request.getParameter("ksbh");
			YsService ysService = new YsService();
			
			//request.setAttribute("ys", ys);
			//request.getRequestDispatcher("/ys/ys.jsp").forward(request, response);}
			List<Ys> yss=ysService.findYsByKsbh(ksbh,Integer.valueOf(pageSize),Integer.valueOf(pageNo));
			int total = ysService.findyssTotalCount(ksbh);
			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", yss);
			
			//将Model处理的结果发送到前台
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			//写shuju
			out.write(json.toString());
			out.close();
			}
		
		else if(reqCode.equals("findysById")){
			//做新增用户操作
			    String id=request.getParameter("id");
				
				// 将获取的参数封装成User
			   
					
					YsService ysService = new YsService();
					Ys ys = ysService.findysById(id);
					JSONObject json = JSONObject.fromObject(ys);
					//将Model处理的结果发送到前台
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					//写shuju
					out.write(json.toString());
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
