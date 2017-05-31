package com.testbs.entity;

public class StuffInfo {
	private int id;
	private String stuffID;
	private String stuffName;
	private String stuffBirth;
	private String stuffSex;
	private String stuffNation;
	private String stuffAddress;
	private String stuffTel;
	private String stuffEmail;
	private String stuffEdu;
	private String stuffColleage;
	private String stuffProfession;
	private String stuffGrade;
	private String stuffWedding;
	private String stuffSkill;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuffID() {
		return stuffID;
	}

	public void setStuffID(String stuffID) {
		this.stuffID = stuffID;
	}

	public String getStuffName() {
		return stuffName;
	}

	public void setStuffName(String stuffName) {
		this.stuffName = stuffName;
	}

	public String getStuffBirth() {
		return stuffBirth;
	}

	public void setStuffBirth(String stuffBirth) {
		this.stuffBirth = stuffBirth;
	}

	public String getStuffSex() {
		return stuffSex;
	}

	public void setStuffSex(String stuffSex) {
		this.stuffSex = stuffSex;
	}

	public String getStuffNation() {
		return stuffNation;
	}

	public void setStuffNation(String stuffNation) {
		this.stuffNation = stuffNation;
	}

	public String getStuffAddress() {
		return stuffAddress;
	}

	public void setStuffAddress(String stuffAddress) {
		this.stuffAddress = stuffAddress;
	}

	public String getStuffTel() {
		return stuffTel;
	}

	public void setStuffTel(String stuffTel) {
		this.stuffTel = stuffTel;
	}

	public String getStuffEmail() {
		return stuffEmail;
	}

	public void setStuffEmail(String stuffEmail) {
		this.stuffEmail = stuffEmail;
	}

	public String getStuffEdu() {
		return stuffEdu;
	}

	public void setStuffEdu(String stuffEdu) {
		this.stuffEdu = stuffEdu;
	}

	public String getStuffColleage() {
		return stuffColleage;
	}

	public void setStuffColleage(String stuffColleage) {
		this.stuffColleage = stuffColleage;
	}

	public String getStuffProfession() {
		return stuffProfession;
	}

	public void setStuffProfession(String stuffProfession) {
		this.stuffProfession = stuffProfession;
	}

	public String getStuffGrade() {
		return stuffGrade;
	}

	public void setStuffGrade(String stuffGrade) {
		this.stuffGrade = stuffGrade;
	}

	public String getStuffWedding() {
		return stuffWedding;
	}

	public void setStuffWedding(String stuffWedding) {
		this.stuffWedding = stuffWedding;
	}

	public String getStuffSkill() {
		return stuffSkill;
	}

	public void setStuffSkill(String stuffSkill) {
		this.stuffSkill = stuffSkill;
	}

	public StuffInfo(int id, String stuffID, String stuffName,
			String stuffBirth, String stuffSex, String stuffNation,
			String stuffAddress, String stuffTel, String stuffEmail,
			String stuffEdu, String stuffColleage, String stuffProfession,
			String stuffGrade, String stuffWedding, String stuffSkill) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffBirth = stuffBirth;
		this.stuffSex = stuffSex;
		this.stuffNation = stuffNation;
		this.stuffAddress = stuffAddress;
		this.stuffTel = stuffTel;
		this.stuffEmail = stuffEmail;
		this.stuffEdu = stuffEdu;
		this.stuffColleage = stuffColleage;
		this.stuffProfession = stuffProfession;
		this.stuffGrade = stuffGrade;
		this.stuffWedding = stuffWedding;
		this.stuffSkill = stuffSkill;
	}

	public StuffInfo(String stuffName, String stuffBirth, String stuffSex,
			String stuffNation, String stuffAddress, String stuffTel,
			String stuffEmail, String stuffEdu, String stuffColleage,
			String stuffProfession, String stuffGrade, String stuffWedding,
			String stuffSkill,String stuffID) {
		super();
		this.stuffName = stuffName;
		this.stuffBirth = stuffBirth;
		this.stuffSex = stuffSex;
		this.stuffNation = stuffNation;
		this.stuffAddress = stuffAddress;
		this.stuffTel = stuffTel;
		this.stuffEmail = stuffEmail;
		this.stuffEdu = stuffEdu;
		this.stuffColleage = stuffColleage;
		this.stuffProfession = stuffProfession;
		this.stuffGrade = stuffGrade;
		this.stuffWedding = stuffWedding;
		this.stuffSkill = stuffSkill;
		this.stuffID = stuffID;
	}

	public StuffInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
