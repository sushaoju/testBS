package com.jyj.entity;

public class Cart{
	//11������
	private String id;
	private String ypbh;
	private String ypmc;
	private String lb;
	private String sccs;
	private String yptm;
	private String ggxh;
	private String pzwh;
	private String bz;
	private String jg;
	private String sl;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getJg() {
		return jg;
	}
	public void setJg(String jg) {
		this.jg = jg;
	}
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	//11��ȫ��
	public Cart(String id, String ypbh, String ypmc, String lb, String sccs,
			String yptm, String ggxh, String pzwh, String bz,String jg,String sl) {
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
		this.sl = sl;
	}
//8��������id�����ݵ�	
	public Cart(String ypbh, String ypmc, String lb, String sccs,
			String ggxh,String jg,String sl,String bz) {
		super();
		this.ypbh = ypbh;
		this.ypmc = ypmc;
		this.lb = lb;
		this.sccs = sccs;
		this.ggxh = ggxh;
		this.jg = jg;
		this.sl = sl;
		this.bz = bz;
		
	}
	
	public Cart(String ypbh, String ypmc, String lb, String sccs,
			String ggxh,String jg,String sl,String bz,String id) {
		super();
		this.ypbh = ypbh;
		this.ypmc = ypmc;
		this.lb = lb;
		this.sccs = sccs;
		this.ggxh = ggxh;
		this.jg = jg;
		this.sl = sl;
		this.bz = bz;
		this.id = id;
	}
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

