package com.testbs.entity;

public class AdminInfo {
	private int id;
	private String stuffID;
	private String stuffName;
	private String resignDate;
	private String account;
	private String password;

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

	public String getResignDate() {
		return resignDate;
	}

	public void setResignDate(String resignDate) {
		this.resignDate = resignDate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminInfo(int id, String stuffID, String stuffName,
			String resignDate, String account, String password) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.resignDate = resignDate;
		this.account = account;
		this.password = password;
	}



	public AdminInfo(String stuffID, String stuffName, String resignDate,
			String account, String password) {
		super();
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.resignDate = resignDate;
		this.account = account;
		this.password = password;
	}

	
	
	public AdminInfo(String stuffID, String account, String password) {
		super();
		this.stuffID = stuffID;
		this.account = account;
		this.password = password;
	}

	
	
	
	public AdminInfo(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public AdminInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
