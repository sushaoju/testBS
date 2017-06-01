package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jyj.dao.BaseDao;
import com.jyj.entity.Answer;


public class ReviewService extends BaseDao{
	

	public List<Answer> getReviewForPage(String question_id,
			String question_name, String question_date, String answer_name,
			String answer_date, String doctor_id, String doctor_name,
			String doctor_account, Integer pageNo,
			Integer pageSize) {
		String query="select q.question_id,q.question_name,q.question_date,a.answer_name,a.answer_date,a.doctor_id,a.doctor_name,a.doctor_account from answer a,question q where a.question_id = q.question_id ";
		List<Object> params=new ArrayList<Object>();
		if(question_id!=null && !"".equals(question_id)){
			query=query +" and question_id like ?";
			params.add("%"+question_id+"%");
		}	
		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<Answer> answers=new ArrayList<Answer>();
		ResultSet rs=this.executeQueryForPages(query,params);
		try {
			while(rs.next()){
				String q_id=rs.getString("question_id");
				String q_name=rs.getString("question_name");
				String q_date=rs.getString("question_date");
				String a_name=rs.getString("answer_name");
				String a_date=rs.getString("answer_date");
				String d_id=rs.getString("doctor_id");
				String d_name=rs.getString("doctor_name");
				String d_account=rs.getString("doctor_account");
				
				Answer answer=new Answer(q_id,q_name,q_date,a_name,a_date,d_id,d_name,d_account);
				answers.add(answer);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.close();
		}
		return answers;
	}

	public int getTotalCount(String question_id, String question_name,
			String question_date, String answer_name, String answer_date,
			String doctor_id, String doctor_name, String doctor_account) {
		String query="select q.question_id,q.question_name,q.question_date,a.answer_name,a.answer_date,a.doctor_id,a.doctor_name,a.doctor_account from answer a,question q where a.question_id = q.question_id";
		List<Object> params=new ArrayList<Object>();
		if(question_id!=null && !"".equals(question_id)){
			query=query +" and question_id like ?";
			params.add("%"+question_id+"%");
		}	
		return this.executeTotalCountForPages(query, params);
	}

}
