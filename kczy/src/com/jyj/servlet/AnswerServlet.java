package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jyj.entity.Answer;
import com.jyj.entity.Question;
import com.jyj.service.AnswerService;
import com.jyj.service.QuestionService;

public class AnswerServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AnswerServlet() {
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
		if(reqCode.equals("findAnswerByquestion_id")){
			//调用model处理
			String question_id = request.getParameter("question_id");
			AnswerService answerService=new AnswerService();
			Answer answer=answerService.findAnswerByQid(question_id);
			
			request.setAttribute("answer",answer);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/zxtw/A_update.jsp");
			dispatcher.forward(request, response);
			
		}else if(reqCode.equals("addanswer")){
			addanswer(request, response);
		}else if(reqCode.equals("updateanswer")){
			//提取数据
	
			String question_id=request.getParameter("question_id");
			String question_name=request.getParameter("question_name");
			String question_date=request.getParameter("question_date");
			String answer_name=request.getParameter("answer_name");
			String answer_date=request.getParameter("answer_date");
			String doctor_id=request.getParameter("doctor_id");
			String doctor_name=request.getParameter("doctor_name");
			String doctor_account=request.getParameter("doctor_account");
			Answer answer=new Answer(question_id,question_name,question_date,answer_name,answer_date,doctor_id,doctor_name,doctor_account);
			//调用model
			AnswerService answerService=new AnswerService();
			int result=answerService.updateanswer(answer);
			
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
	
	private void addanswer(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String question_id=request.getParameter("question_id");
		String question_name=request.getParameter("question_name");
		String question_date=request.getParameter("question_date");
		String answer_name=request.getParameter("answer_name");
		String answer_date=request.getParameter("answer_date");
		String doctor_id=request.getParameter("doctor_id");
		String doctor_name=request.getParameter("doctor_name");
		String doctor_account=request.getParameter("doctor_account");
				
		Answer p=new Answer();
		p.setQuestion_id(question_id);
		p.setQuestion_name(question_name);
		p.setQuestion_date(question_date);
		p.setAnswer_name(answer_name);
		p.setAnswer_date(answer_date);
		p.setDoctor_id(doctor_id);
		p.setDoctor_name(doctor_name);
		p.setDoctor_account(doctor_account);
		
		AnswerService answerService=new AnswerService();
		int result=answerService.addanswer(p);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		
		if(result>0){
			out.write("成功");
		}else{
			out.write("失败");
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
