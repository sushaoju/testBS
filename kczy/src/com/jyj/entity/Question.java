package com.jyj.entity;

import javax.xml.crypto.Data;

public class Question {
	
	private String question_id;
	private String question_name;
	private String question_date;
	private String patient_id;
	private String patient_name;
	private String patient_account;
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
	public String getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getPatient_account() {
		return patient_account;
	}
	public void setPatient_account(String patient_account) {
		this.patient_account = patient_account;
	}
	public Question(String question_id, String question_name,
			String question_date, String patient_id, String patient_name,
			String patient_account) {
		super();
		this.question_id = question_id;
		this.question_name = question_name;
		this.question_date = question_date;
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.patient_account = patient_account;
	}
	public Question() {
		super();
	}
	
	
	

}
