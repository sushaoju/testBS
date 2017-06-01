package com.jyj.entity;

import java.util.List;

public class Ks {
private int id;
private String ksbh;
private String ksmc;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getKsbh() {
	return ksbh;
}
public void setKsbh(String ksbh) {
	this.ksbh = ksbh;
}
public String getKsmc() {
	return ksmc;
}
public void setKsmc(String ksmc) {
	this.ksmc = ksmc;
}
public Ks(int id, String ksbh, String ksmc) {
	super();
	this.id = id;
	this.ksbh = ksbh;
	this.ksmc = ksmc;
}
public Ks() {
	super();
	// TODO Auto-generated constructor stub
}


}