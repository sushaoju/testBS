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

import com.jyj.entity.Answer;
import com.jyj.entity.Question;
import com.jyj.service.AnswerService;
import com.jyj.service.QuestionService;
import com.jyj.service.ReviewService;

public class ReviewServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ReviewServlet() {
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
		if(reqCode.equals("findReviewForpage")){
			//当前页码
			String pageNo=request.getParameter("page");
			//页面大小
			String pageSize=request.getParameter("rows");
			//获取查询参数
			
			String question_id=request.getParameter("question_id");
			String question_name=request.getParameter("question_name");
			String question_date=request.getParameter("question_date");
			String answer_name=request.getParameter("answer_name");
			String answer_date=request.getParameter("answer_date");
			String doctor_id=request.getParameter("doctor_id");
			String doctor_name=request.getParameter("doctor_name");
			String doctor_account=request.getParameter("doctor_account");
			
			ReviewService reviewService=new ReviewService();
			List<Answer> answer=reviewService.getReviewForPage(question_id,question_name,question_date,answer_name,answer_date,doctor_id,doctor_name,doctor_account,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
			int total=reviewService.getTotalCount(question_id,question_name,question_date,answer_name,answer_date,doctor_id,doctor_name,doctor_account);
			
			JSONObject json=new JSONObject();
			json.put("total",total);
			json.put("rows",answer);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
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
