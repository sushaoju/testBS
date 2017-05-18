package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jyj.dao.BaseDao;
import com.jyj.entity.Question;

public class QuestionService extends BaseDao{
	
	public List<Question> getQuestionForPage(String question_id, String question_name, String question_date,
			String patient_id, String patient_name, String patient_account, Integer pageNo,
			Integer pageSize) {
		String query="select question_id,question_name,question_date,patient_id,patient_name,patient_account from question where 1=1";
		List<Object> params=new ArrayList<Object>();
		if(question_id!=null && !"".equals(question_id)){
			query=query +" and question_id like ?";
			params.add("%"+question_id+"%");
		}	
		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<Question> questions=new ArrayList<Question>();
		ResultSet rs=this.executeQueryForPages(query,params);
		try {
			while(rs.next()){
				String q_id=rs.getString("question_id");
				String q_name=rs.getString("question_name");
				String q_date=rs.getString("question_date");
				String p_id=rs.getString("patient_id");
				String p_name=rs.getString("patient_name");
				String p_account=rs.getString("patient_account");
				
				Question question=new Question(q_id,q_name,q_date,p_id,p_name,p_account);
				questions.add(question);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.close();
		}
		return questions;
	}


	public int getTotalCount(String question_id, String question_name, String question_date,
			String patient_id, String patient_name, String patient_account) {
		String query="select question_id,question_name,question_date,patient_id,patient_name,patient_account from question where 1=1";
		List<Object> params=new ArrayList<Object>();
		if(question_id!=null && !"".equals(question_id)){
			query=query +" and question_id like ?";
			params.add("%"+question_id+"%");
		}	
		return this.executeTotalCountForPages(query, params);
	}
	
	public int addquestion(Question p) {
		int result=0;
		String sql="insert into question(question_id,question_name,question_date,patient_id,patient_name,patient_account) values(?,?,?,?,?,?)";
		
		List<Object> params=new ArrayList<Object>();
		params.add(p.getQuestion_id());
		params.add(p.getQuestion_name());
		params.add(p.getQuestion_date());
		params.add(p.getPatient_id());
		params.add(p.getPatient_name());
		params.add(p.getPatient_account());
		
		result=this.executeUpdate(sql, params);
		return result;
	}
	
	public int deletequestion(Question p) {
		int result=0;
		String sql="delete from question where question_id= ?";
		
		List<Object> params=new ArrayList<Object>();
		params.add(p.getQuestion_id());
		result=this.executeUpdate(sql, params);
	
		return result;
	}


	public Question findQuestionByQid(String qid) {
		
		List<Object> questions=new ArrayList<Object>();
		String query="select question_id,question_name,question_date,patient_id,patient_name,patient_account from question where question_id=? ";
		questions.add(qid);
		ResultSet rs= this.executeQuery(query,questions);
		//将数据从rs中取出并封装成对象
		try {
			while(rs.next()){
				String question_id=rs.getString("question_id");
				String question_name=rs.getString("question_name");
				String question_date=rs.getString("question_date");
				String patient_id=rs.getString("patient_id");
				String patient_name=rs.getString("patient_name");
				String patient_account=rs.getString("patient_account");
				
				Question question=new Question(question_id,question_name,question_date,patient_id,patient_name,patient_account);
				return question;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.close();
		}
		return null;
	}


	public int updatequestion(Question question) {
		String update="update question set question_name=?,question_date=?,patient_id=?,patient_name=?,patient_account=?  where question_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(question.getQuestion_name());
		params.add(question.getQuestion_date());
		params.add(question.getPatient_id());
		params.add(question.getPatient_name());
		params.add(question.getPatient_account());
		params.add(question.getQuestion_id());
		return this.executeUpdate(update, params);
	}



	}

	

