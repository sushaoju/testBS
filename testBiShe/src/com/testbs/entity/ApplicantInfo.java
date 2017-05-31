package com.testbs.entity;

public class ApplicantInfo {
	private int id;
	private String apName;
	private String apDuty;
	private int apAge;
	private String apEdu;
	private String apSkill;
	private String apExperience;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApName() {
		return apName;
	}

	public void setApName(String apName) {
		this.apName = apName;
	}

	public String getApDuty() {
		return apDuty;
	}

	public void setApDuty(String apDuty) {
		this.apDuty = apDuty;
	}

	public int getApAge() {
		return apAge;
	}

	public void setApAge(int apAge) {
		this.apAge = apAge;
	}

	public String getApEdu() {
		return apEdu;
	}

	public void setApEdu(String apEdu) {
		this.apEdu = apEdu;
	}

	public String getApSkill() {
		return apSkill;
	}

	public void setApSkill(String apSkill) {
		this.apSkill = apSkill;
	}

	public String getApExperience() {
		return apExperience;
	}

	public void setApExperience(String apExperience) {
		this.apExperience = apExperience;
	}

	public ApplicantInfo(int id, String apName, String apDuty, int apAge,
			String apEdu, String apSkill, String apExperience) {
		super();
		this.id = id;
		this.apName = apName;
		this.apDuty = apDuty;
		this.apAge = apAge;
		this.apEdu = apEdu;
		this.apSkill = apSkill;
		this.apExperience = apExperience;
	}

	public ApplicantInfo(String apName, String apDuty, int apAge, String apEdu,
			String apSkill, String apExperience) {
		super();
		this.apName = apName;
		this.apDuty = apDuty;
		this.apAge = apAge;
		this.apEdu = apEdu;
		this.apSkill = apSkill;
		this.apExperience = apExperience;
	}

	public ApplicantInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
