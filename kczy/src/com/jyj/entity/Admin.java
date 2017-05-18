package com.jyj.entity;

public class Admin {
	
	private String account;
	private String pwd;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Admin(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
	}
	public Admin() {
		super();
	}
	
	

}
