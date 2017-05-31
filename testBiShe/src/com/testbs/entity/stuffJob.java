package com.testbs.entity;

public class stuffJob {
	private String stuffID;
	private String stuffName;
	private String stuffSex;
	private String stuffDuty;
	private String stuffDepart;
	private String stuffStatus;
	private String stuffTel;
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
	public String getStuffSex() {
		return stuffSex;
	}
	public void setStuffSex(String stuffSex) {
		this.stuffSex = stuffSex;
	}
	public String getStuffDuty() {
		return stuffDuty;
	}
	public void setStuffDuty(String stuffDuty) {
		this.stuffDuty = stuffDuty;
	}
	public String getStuffDepart() {
		return stuffDepart;
	}
	public void setStuffDepart(String stuffDepart) {
		this.stuffDepart = stuffDepart;
	}
	public String getStuffStatus() {
		return stuffStatus;
	}
	public void setStuffStatus(String stuffStatus) {
		this.stuffStatus = stuffStatus;
	}
	public String getStuffTel() {
		return stuffTel;
	}
	public void setStuffTel(String stuffTel) {
		this.stuffTel = stuffTel;
	}
	public stuffJob(String stuffID, String stuffName, String stuffSex,
			String stuffDuty, String stuffDepart, String stuffStatus,
			String stuffTel) {
		super();
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffSex = stuffSex;
		this.stuffDuty = stuffDuty;
		this.stuffDepart = stuffDepart;
		this.stuffStatus = stuffStatus;
		this.stuffTel = stuffTel;
	}
	public stuffJob() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
