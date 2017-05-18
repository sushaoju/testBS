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

import com.jyj.entity.Question;
import com.jyj.service.QuestionService;

public class QuestionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QuestionServlet() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String reqCode=request.getParameter("reqCode");
		if(reqCode.equals("findQuestionForpage")){
			//当前页码
			String pageNo=request.getParameter("page");
			//页面大小
			String pageSize=request.getParameter("rows");
			//获取查询参数
			
			String question_id=request.getParameter("question_id");
			String question_name=request.getParameter("question_name");
			String question_date=request.getParameter("question_date");
			String patient_id=request.getParameter("patient_id");
			String patient_name=request.getParameter("patient_name");
			String patient_account=request.getParameter("patient_account");
			
			QuestionService questionService=new QuestionService();
			List<Question> question=questionService.getQuestionForPage(question_id,question_name,question_date,patient_id,patient_name,patient_account,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
			int total=questionService.getTotalCount(question_id,question_name,question_date,patient_id,patient_name,patient_account);
			
			JSONObject json=new JSONObject();
			json.put("total",total);
			json.put("rows",question);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("addquestion")){
			addquestion(request, response);
		}else if(reqCode.equals("delquestion")){
		    delquestion(request, response);
		}else if(reqCode.equals("findQuestionByquestion_id")){
			//调用model处理
			String question_id = request.getParameter("question_id");
			QuestionService questionService=new QuestionService();
			Question question=questionService.findQuestionByQid(question_id);
			
			request.setAttribute("question",question);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/zxtw/Q_update.jsp");
			dispatcher.forward(request, response);
			
		}else if(reqCode.equals("updatequestion")){
			//提取数据
	
			String question_id=request.getParameter("question_id");
			String question_name=request.getParameter("question_name");
			String question_date=request.getParameter("question_date");
			String patient_id=request.getParameter("patient_id");
			String patient_name=request.getParameter("patient_name");
			String patient_account=request.getParameter("patient_account");
			Question question=new Question(question_id,question_name,question_date,patient_id,patient_name,patient_account);
			//调用model
			QuestionService questionService=new QuestionService();
			int result=questionService.updatequestion(question);
			
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
	
	private void addquestion(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String question_id=request.getParameter("question_id");
		String question_name=request.getParameter("question_name");
		String question_date=request.getParameter("question_date");
		String patient_id=request.getParameter("patient_id");
		String patient_name=request.getParameter("patient_name");
		String patient_account=request.getParameter("patient_account");
				
		Question p=new Question();
		p.setQuestion_id(question_id);
		p.setQuestion_name(question_name);
		p.setQuestion_date(question_date);
		p.setPatient_id(patient_id);
		p.setPatient_name(patient_name);
		p.setPatient_account(patient_account);
		
		QuestionService questionService=new QuestionService();
		int result=questionService.addquestion(p);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		
		if(result>0){
			out.write("新增成功");
		}else{
			out.write("新增失败");
		}
		out.close();	
	}
	
	private void delquestion(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String question_id=request.getParameter("question_id");
		Question p=new Question();
		p.setQuestion_id(question_id);
		
		QuestionService questionService=new QuestionService();
		int result=questionService.deletequestion(p);
		
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
