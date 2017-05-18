package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;



import com.jyj.entity.Fkd;
import com.jyj.entity.Ghd;
import com.jyj.entity.Ks;
import com.jyj.service.FkdService;
import com.jyj.service.KsService;

public class fkServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public fkServlet() {
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
	
	if(reqCode.equals("findAllFkds")){
		String pageSize = request.getParameter("rows");
		String pageNo = request.getParameter("page");
		String p_account = request.getParameter("p_account");
		FkdService fkdService=new FkdService();
		List<Fkd> fkds=fkdService.findFkds(Integer.valueOf(pageSize),Integer.valueOf(pageNo),p_account);
		int total = fkdService.findFkdsTotalCount(p_account);
		JSONObject json = new JSONObject();
		json.put("total", total);
		json.put("rows", fkds);
		
		//将Model处理的结果发送到前台
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//写shuju
		out.write(json.toString());
		out.close();
		}
	 if(reqCode.equals("findfkdById")){
		
		String id = request.getParameter("id");
		FkdService fkdService = new FkdService();
		Fkd fkd = fkdService.findfkdById(id);
		JSONObject json = JSONObject.fromObject(fkd);
		//将Model处理的结果发送到前台
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//写shuju
		out.write(json.toString());
		out.close();
	}
	 if(reqCode.equals("findfkdmxById")){
		 String pageSize = request.getParameter("rows");
			String pageNo = request.getParameter("page");
			String id = request.getParameter("id");
			FkdService fkdService = new FkdService();
			List<Fkd> fkds=fkdService.findFkdsmx(Integer.valueOf(pageSize),Integer.valueOf(pageNo),id);
			int total = fkdService.findFkdsTotalCount2(id);
			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", fkds);
			
			//将Model处理的结果发送到前台
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			//写shuju
			out.write(json.toString());
			out.close();
			}
		 
	 

		 if(reqCode.equals("addFkd")){
			//做新增用户操作
				String p_account = request.getParameter("p_account");
				String ghf = request.getParameter("ghf");
				String wzfy = request.getParameter("wzfy");
				String cfdje=request.getParameter("cfdje");
				String zje=request.getParameter("zje");
				String sgks = request.getParameter("sgks");
				String d_name=request.getParameter("d_name");
				String ypmc=request.getParameter("ypmc");
				
				// 将获取的参数封装成User
				Fkd fkd = new Fkd();
				
				fkd.setP_account(p_account);
				fkd.setGhf(ghf);
				fkd.setWzfy(wzfy);
				fkd.setCfdje(cfdje);
				fkd.setZje(zje);
				fkd.setSgks(sgks);
				fkd.setD_name(d_name);
				fkd.setYpmc(ypmc);
				
				FkdService fkdService = new FkdService();
				int result = fkdService.addFkd(fkd);

				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();

				if (result > 0) {
					out.write("付款成功！");
				} else {
					out.write("付款失败！");
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
