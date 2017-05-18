package com.jyj.entity;

public class Fkd {
	private int id;
	private String p_account;
	private String ghf;
	private String wzfy;
	private String cfdje;
	private String zje;
	private String sgks;
	private String d_name;
	private String ypmc;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getP_account() {
		return p_account;
	}
	public void setP_account(String p_account) {
		this.p_account = p_account;
	}
	public String getGhf() {
		return ghf;
	}
	public void setGhf(String ghf) {
		this.ghf = ghf;
	}
	public String getWzfy() {
		return wzfy;
	}
	public void setWzfy(String wzfy) {
		this.wzfy = wzfy;
	}
	public String getCfdje() {
		return cfdje;
	}
	public void setCfdje(String cfdje) {
		this.cfdje = cfdje;
	}
	public String getZje() {
		return zje;
	}
	public void setZje(String zje) {
		this.zje = zje;
	}
	public String getSgks() {
		return sgks;
	}
	public void setSgks(String sgks) {
		this.sgks = sgks;
		
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
		
	}
	public String getYpmc() {
		return ypmc;
	}
	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
		
	}
	
	public Fkd(int id, String p_account, String ghf, String wzfy, String cfdje,
			String zje) {
		super();
		this.id = id;
		this.p_account = p_account;
		this.ghf = ghf;
		this.wzfy = wzfy;
		this.cfdje = cfdje;
		this.zje = zje;
	}
	public Fkd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fkd(int id, String p_account, String ghf, String wzfy,
			String cfdje, String zje, String sgks, String d_name, String ypmc) {
		this.id = id;
		this.p_account = p_account;
		this.ghf = ghf;
		this.wzfy = wzfy;
		this.cfdje = cfdje;
		this.zje = zje;
		this.sgks = sgks;
		this.d_name = d_name;
		this.ypmc = ypmc;
		
		
		// TODO Auto-generated constructor stub
	}
	public Fkd(String p_account, String ghf, String wzfy, String cfdje,
			String zje, String sgks, String d_name, String ypmc, int id) {
		this.p_account = p_account;
		this.ghf = ghf;
		this.wzfy = wzfy;
		this.cfdje = cfdje;
		this.zje = zje;
		this.sgks = sgks;
		this.d_name = d_name;
		this.ypmc = ypmc;
		this.id = id;
		
		// TODO Auto-generated constructor stub
	}
	
	
	

}
