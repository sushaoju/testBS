package com.jyj.entity;

public class Patient {
	
	private String id;
	private String account;
	private String pwd;
	private String name;
	private String jibie;
	private String age;
	private String sex;
	private String number;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJibie() {
		return jibie;
	}
	public void setJibie(String jibie) {
		this.jibie = jibie;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Patient(String id, String account, String pwd, String name,
			String jibie, String age, String sex, String number, String address) {
		super();
		this.id = id;
		this.account = account;
		this.pwd = pwd;
		this.name = name;
		this.jibie = jibie;
		this.age = age;
		this.sex = sex;
		this.number = number;
		this.address = address;
	}
	public Patient() {
		super();
	}
	
	

}
