package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jyj.dao.BaseDao;
import com.jyj.entity.Answer;
import com.jyj.entity.Question;

public class AnswerService extends BaseDao{

	public Answer findAnswerByQid(String question_id) {
		List<Object> questions=new ArrayList<Object>();
		String query="select question_id,question_name,question_date,answer_name,answer_date,doctor_id,doctor_name,doctor_account from answer where question_id=? ";
		questions.add(question_id);
		ResultSet rs= this.executeQuery(query,questions);
		//将数据从rs中取出并封装成对象
		try {
			while(rs.next()){
				String q_id=rs.getString("question_id");
				String question_name=rs.getString("question_name");
				String question_date=rs.getString("question_date");
				String answer_name=rs.getString("answer_name");
				String answer_date=rs.getString("answer_date");
				String doctor_id=rs.getString("doctor_id");
				String doctor_name=rs.getString("doctor_name");
				String doctor_account=rs.getString("doctor_account");
				
				Answer answer=new Answer(q_id,question_name,question_date,answer_name,answer_date,doctor_id,doctor_name,doctor_account);
				return answer;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.close();
		}
		return null;
	}
	
	public int addanswer(Answer p) {
		int result=0;
		String sql="insert into answer(question_id,question_name,question_date,answer_name,answer_date,doctor_id,doctor_name,doctor_account) values(?,?,?,?,?,?,?,?)";
		
		List<Object> params=new ArrayList<Object>();
		params.add(p.getQuestion_id());
		params.add(p.getQuestion_name());
		params.add(p.getQuestion_date());
		params.add(p.getAnswer_name());
		params.add(p.getAnswer_date());
		params.add(p.getDoctor_id());
		params.add(p.getDoctor_name());
		params.add(p.getDoctor_account());
		
		result=this.executeUpdate(sql, params);
		return result;
	}

	public int updateanswer(Answer answer) {
		String update="update answer set question_name=?,question_date=?,answer_name=?,answer_date=?,doctor_id=?,doctor_name=?,doctor_account=?  where question_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(answer.getQuestion_name());
		params.add(answer.getQuestion_date());
		params.add(answer.getAnswer_name());
		params.add(answer.getAnswer_date());
		params.add(answer.getDoctor_id());
		params.add(answer.getDoctor_name());
		params.add(answer.getDoctor_account());
		params.add(answer.getQuestion_id());
		return this.executeUpdate(update, params);
	}
	}

