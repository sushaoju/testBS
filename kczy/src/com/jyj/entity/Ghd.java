package com.jyj.entity;

public class Ghd {
	private int g_id;
	private String p_account;
	private String d_name;
	private String id;
	private String szks;
	private String szyy;
	private String p_age;
	private String p_sex;
	private String p_address;
	
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getP_account() {
		return p_account;
	}
	public void setP_account(String p_account) {
		this.p_account = p_account;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSzks() {
		return szks;
	}
	public void setSzks(String szks) {
		this.szks = szks;
	}
	public String getSzyy() {
		return szyy;
	}
	public void setSzyy(String szyy) {
		this.szyy = szyy;
	}
	public String getP_age() {
		return p_age;
	}
	public void setP_age(String p_age) {
		this.p_age = p_age;
	}
	public String getP_sex() {
		return p_sex;
	}
	public void setP_sex(String p_sex) {
		this.p_sex = p_sex;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	public Ghd(int g_id, String p_account, String d_name, String id,
			String szks, String szyy, String p_age, String p_sex,String p_address) {
		super();
		this.g_id = g_id;
		this.p_account = p_account;
		this.d_name = d_name;
		this.id = id;
		this.szks = szks;
		this.szyy = szyy;
		this.p_age = p_age;
		this.p_sex = p_sex;
		this.p_address = p_address;
		
	}
	public Ghd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ghd(int g_id, String p_account, String p_age, String p_sex,
			String p_address, String d_name, String szks, String szyy) {
		this.g_id = g_id;
		this.p_account = p_account;	
		this.p_age = p_age;
		this.p_sex = p_sex;
		this.p_address = p_address;
		this.d_name = d_name;
		this.szks = szks;
		this.szyy = szyy;
		
		
		// TODO Auto-generated constructor stub
	}
	

}
