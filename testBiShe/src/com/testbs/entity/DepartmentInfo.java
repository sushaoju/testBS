package com.testbs.entity;

public class DepartmentInfo {
	private int id;
	private String departID;
	private String departName;
	private String departPrince;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartID() {
		return departID;
	}
	public void setDepartID(String departID) {
		this.departID = departID;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getDepartPrince() {
		return departPrince;
	}
	public void setDepartPrince(String departPrince) {
		this.departPrince = departPrince;
	}
	//È«²Î
	public DepartmentInfo(int id, String departID, String departName,
			String departPrince) {
		super();
		this.id = id;
		this.departID = departID;
		this.departName = departName;
		this.departPrince = departPrince;
	}
	
	//ÎÞid
	public DepartmentInfo( String departID, String departName,
			String departPrince) {
		super();
		this.departID = departID;
		this.departName = departName;
		this.departPrince = departPrince;
	}
	
	
	public DepartmentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
