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

import com.jyj.entity.Patient;
import com.jyj.entity.Question;
import com.jyj.service.PatientService;
import com.jyj.service.QuestionService;

public class PatientServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PatientServlet() {
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
		if(reqCode.equals("findPatientForPage")){
			//当前页码
			String pageNo=request.getParameter("page");
			//页面大小
			String pageSize=request.getParameter("rows");
			//获取查询参数
			String id=request.getParameter("id");
			String account=request.getParameter("account");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			String jibie=request.getParameter("jibie");
			String age=request.getParameter("age");			
			String sex=request.getParameter("sex");
			String number=request.getParameter("number");
			String address=request.getParameter("address");
			
			PatientService patientService=new PatientService();
			List<Patient> patient=patientService.getPatientForPage(
					id,account,pwd,name,jibie,age,sex,number,address,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
			int total=patientService.getTotalCount(id,account,pwd,name,jibie,age,sex,number,address);
			
			JSONObject json=new JSONObject();
			json.put("total",total);
			json.put("rows",patient);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("addpatient")){
			addpatient(request, response);
		}else if(reqCode.equals("delpatient")){
		    delpatient(request, response);
		}else if(reqCode.equals("findPatientByid")){
			//调用model处理
			String id = request.getParameter("id");
			PatientService patientService=new PatientService();
			Patient patient=patientService.findPatientByid(id);
			
			request.setAttribute("patient",patient);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/user/p_update.jsp");
			dispatcher.forward(request, response);
			
		}else if(reqCode.equals("updatepatient")){
			//提取数据
	
			String id=request.getParameter("id");
			String account=request.getParameter("account");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			String jibie=request.getParameter("jibie");
			String age=request.getParameter("age");			
			String sex=request.getParameter("sex");
			String number=request.getParameter("number");
			String address=request.getParameter("address");
			Patient patient=new Patient(id,account,pwd,name,jibie,age,sex,number,address);
			//调用model
			PatientService patientService=new PatientService();
			int result=patientService.updatepatient(patient);
			
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
	private void addpatient(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//String id=request.getParameter("id");
		String account=request.getParameter("account");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String jibie=request.getParameter("jibie");
		String age=request.getParameter("age");			
		String sex=request.getParameter("sex");
		String number=request.getParameter("number");
		String address=request.getParameter("address");
		
				
		Patient p=new Patient();
		//p.setId(id);
		p.setAccount(account);
		p.setPwd(pwd);
		p.setName(name);
		p.setJibie(jibie);
		p.setAge(age);
		p.setSex(sex);
		p.setNumber(number);
		p.setAddress(address);
		
		PatientService patientService=new PatientService();
		int result=patientService.addpatient(p);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		
		if(result>0){
			out.write("新增成功");
		}else{
			out.write("新增失败");
		}
		out.close();	
	}
	
	private void delpatient(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id=request.getParameter("id");
		Patient p=new Patient();
		p.setId(id);
		
		PatientService patientService=new PatientService();
		int result=patientService.deletepatient(p);
		
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
