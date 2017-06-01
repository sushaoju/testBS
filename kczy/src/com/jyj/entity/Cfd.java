package com.jyj.entity;

public class Cfd {
private int id;
private String d_id;
private String p_account;
private String ypmc;
private String ypsl;
private String zje;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getD_id() {
	return d_id;
}
public void setD_id(String d_id) {
	this.d_id = d_id;
}
public String getP_account() {
	return p_account;
}
public void setP_account(String p_account) {
	this.p_account = p_account;
}
public String getYpmc() {
	return ypmc;
}
public void setYpmc(String ypmc) {
	this.ypmc = ypmc;
}
public String getYpsl() {
	return ypsl;
}
public void setYpsl(String ypsl) {
	this.ypsl = ypsl;
}
public String getZje() {
	return zje;
}
public void setZje(String zje) {
	this.zje = zje;
}
public Cfd(int id, String d_id, String p_account, String ypmc, String ypsl,
		String zje) {
	super();
	this.id = id;
	this.d_id = d_id;
	this.p_account = p_account;
	this.ypmc = ypmc;
	this.ypsl = ypsl;
	this.zje = zje;
}
public Cfd() {
	super();
	// TODO Auto-generated constructor stub
}




}
