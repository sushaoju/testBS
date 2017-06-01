package com.jyj.entity;

public class Doctor {
	
	private String id;
	private String account;
	private String pwd;
	private String d_name;
	private String jibie;
	private String age;
	private String sex;
	private String phone;
	private String address;
	private String ksbh;
	private String szks;
	private String zc;
	private String szyy;
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
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getKsbh() {
		return ksbh;
	}
	public void setKsbh(String ksbh) {
		this.ksbh = ksbh;
	}
	public String getSzks() {
		return szks;
	}
	public void setSzks(String szks) {
		this.szks = szks;
	}
	public String getZc() {
		return zc;
	}
	public void setZc(String zc) {
		this.zc = zc;
	}
	public String getSzyy() {
		return szyy;
	}
	public void setSzyy(String szyy) {
		this.szyy = szyy;
	}
	public Doctor(String id, String account, String pwd, String d_name,
			String jibie, String age, String sex, String phone,
			String address, String ksbh, String szks, String zc, String szyy) {
		super();
		this.id = id;
		this.account = account;
		this.pwd = pwd;
		this.d_name = d_name;
		this.jibie = jibie;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.ksbh = ksbh;
		this.szks = szks;
		this.zc = zc;
		this.szyy = szyy;
	}
	public Doctor() {
		super();
	}
	
	

}
