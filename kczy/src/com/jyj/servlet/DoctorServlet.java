package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.jyj.entity.Doctor;
import com.jyj.entity.Patient;
import com.jyj.service.DoctorService;
import com.jyj.service.PatientService;

public class DoctorServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DoctorServlet() {
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
		String reqCode=request.getParameter("reqCode");
		if(reqCode.equals("findDoctorForPage")){
			//当前页码
			String pageNo=request.getParameter("page");
			//页面大小
			String pageSize=request.getParameter("rows");
			//获取查询参数
			String id=request.getParameter("id");
			String account=request.getParameter("account");
			String pwd=request.getParameter("pwd");
			String d_name=request.getParameter("d_name");
			String jibie=request.getParameter("jibie");
			String age=request.getParameter("age");			
			String sex=request.getParameter("sex");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			String ksbh=request.getParameter("ksbh");			
			String szks=request.getParameter("szks");
			String zc=request.getParameter("zc");
			String szyy=request.getParameter("szyy");
			
			DoctorService doctorService=new DoctorService();
			List<Doctor> doctor=doctorService.getDoctorForPage(
					id,account,pwd,d_name,jibie,age,sex,phone,address,ksbh,szks,zc,szyy,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
			int total=doctorService.getTotalCount(id,account,pwd,d_name,jibie,age,sex,phone,address,ksbh,szks,zc,szyy);
			
			JSONObject json=new JSONObject();
			json.put("total",total);
			json.put("rows",doctor);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("adddoctor")){
			adddoctor(request, response);
		}else if(reqCode.equals("deldoctor")){
		    deldoctor(request, response);
		}else if(reqCode.equals("findDoctorByid")){
			//调用model处理
			String id = request.getParameter("id");
			DoctorService doctorService=new DoctorService();
			Doctor doctor=doctorService.findDoctorByid(id);
			
			request.setAttribute("doctor",doctor);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/user/d_update.jsp");
			dispatcher.forward(request, response);
			
		}else if(reqCode.equals("updatedoctor")){
			//提取数据
	
			String id=request.getParameter("id");
			String account=request.getParameter("account");
			String pwd=request.getParameter("pwd");
			String d_name=request.getParameter("d_name");
			String jibie=request.getParameter("jibie");
			String age=request.getParameter("age");			
			String sex=request.getParameter("sex");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			String ksbh=request.getParameter("ksbh");			
			String szks=request.getParameter("szks");
			String zc=request.getParameter("zc");
			String szyy=request.getParameter("szyy");
			
			Doctor doctor=new Doctor(id,account,pwd,d_name,jibie,age,sex,phone,address,ksbh,szks,zc,szyy);
			//调用model
			DoctorService doctorService=new DoctorService();
			int result=doctorService.updatedoctor(doctor);
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			if(result>0){
				out.write("保存成功");
			}else{
				out.write("保存失败");
			}
			out.close();
			
		}
	}
	
	private void adddoctor(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id=request.getParameter("id");
		String account=request.getParameter("account");
		String pwd=request.getParameter("pwd");
		String d_name=request.getParameter("d_name");
		String jibie=request.getParameter("jibie");
		String age=request.getParameter("age");			
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String ksbh=request.getParameter("ksbh");			
		String szks=request.getParameter("szks");
		String zc=request.getParameter("zc");
		String szyy=request.getParameter("szyy");
		
				
		Doctor p=new Doctor();
		p.setId(id);
		p.setAccount(account);
		p.setPwd(pwd);
		p.setD_name(d_name);
		p.setJibie(jibie);
		p.setAge(age);
		p.setSex(sex);
		p.setPhone(phone);
		p.setAddress(address);
		p.setKsbh(ksbh);
		p.setSzks(szks);
		p.setZc(zc);
		p.setSzyy(szyy);
		
		DoctorService doctorService=new DoctorService();
		int result=doctorService.adddoctor(p);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		
		if(result>0){
			out.write("新增成功");
		}else{
			out.write("新增失败");
		}
		out.close();	
	}
	
	private void deldoctor(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id=request.getParameter("id");
		Doctor p=new Doctor();
		p.setId(id);
		
		DoctorService doctorService=new DoctorService();
		int result=doctorService.deletedoctor(p);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		
		if(result>0){
			out.write("删除成功");
		}else{
			out.write("删除失败");
		}
		out.close();
		
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
