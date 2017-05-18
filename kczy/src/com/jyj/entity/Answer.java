package com.jyj.entity;

public class Answer {
	
	private String question_id;
	private String question_name;
	private String question_date;
	private String answer_name;
	private String answer_date;
	private String doctor_id;
	private String doctor_name;
	private String doctor_account;
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	public String getQuestion_date() {
		return question_date;
	}
	public void setQuestion_date(String question_date) {
		this.question_date = question_date;
	}
	public String getAnswer_name() {
		return answer_name;
	}
	public void setAnswer_name(String answer_name) {
		this.answer_name = answer_name;
	}
	public String getAnswer_date() {
		return answer_date;
	}
	public void setAnswer_date(String answer_date) {
		this.answer_date = answer_date;
	}
	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDoctor_account() {
		return doctor_account;
	}
	public void setDoctor_account(String doctor_account) {
		this.doctor_account = doctor_account;
	}
	public Answer(String question_id, String question_name,
			String question_date, String answer_name, String answer_date,
			String doctor_id, String doctor_name, String doctor_account) {
		super();
		this.question_id = question_id;
		this.question_name = question_name;
		this.question_date = question_date;
		this.answer_name = answer_name;
		this.answer_date = answer_date;
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.doctor_account = doctor_account;
	}
	public Answer() {
		super();
	}
	
	public Answer(String question_id, String answer_name, String answer_date,
			String doctor_id, String doctor_name, String doctor_account) {
		super();
		this.question_id = question_id;
		this.answer_name = answer_name;
		this.answer_date = answer_date;
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.doctor_account = doctor_account;
	}
	

}
