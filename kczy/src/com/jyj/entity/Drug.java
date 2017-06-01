package com.jyj.entity;

public class Drug {
	//10个属性
	private int id;
	private String ypbh;
	private String ypmc;
	private String lb;
	private String sccs;
	private String yptm;
	private String ggxh;
	private String pzwh;
	private String bz;
	private double jg;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYpbh() {
		return ypbh;
	}
	public void setYpbh(String ypbh) {
		this.ypbh = ypbh;
	}
	public String getYpmc() {
		return ypmc;
	}
	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}
	public String getLb() {
		return lb;
	}
	public void setLb(String lb) {
		this.lb = lb;
	}
	public String getSccs() {
		return sccs;
	}
	public void setSccs(String sccs) {
		this.sccs = sccs;
	}
	public String getYptm() {
		return yptm;
	}
	public void setYptm(String yptm) {
		this.yptm = yptm;
	}
	public String getGgxh() {
		return ggxh;
	}
	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}
	public String getPzwh() {
		return pzwh;
	}
	public void setPzwh(String pzwh) {
		this.pzwh = pzwh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public double getJg() {
		return jg;
	}
	public void setJg(double jg) {
		this.jg = jg;
	}
	
	//10个全部
	public Drug(int id, String ypbh, String ypmc, String lb, String sccs,
			String yptm, String ggxh, String pzwh, String bz,double jg) {
		super();
		this.id = id;
		this.ypbh = ypbh;
		this.ypmc = ypmc;
		this.lb = lb;
		this.sccs = sccs;
		this.yptm = yptm;
		this.ggxh = ggxh;
		this.pzwh = pzwh;
		this.bz = bz;
		this.jg = jg;
	}
//9个，根据id返数据的	
	public Drug(String ypbh, String ypmc, String lb, String sccs,
			String yptm, String ggxh, String pzwh, String bz,double jg) {
		super();
		this.ypbh = ypbh;
		this.ypmc = ypmc;
		this.lb = lb;
		this.sccs = sccs;
		this.yptm = yptm;
		this.ggxh = ggxh;
		this.pzwh = pzwh;
		this.bz = bz;
		this.jg = jg;
	}
	
	public Drug() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

