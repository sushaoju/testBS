package com.testbs.entity;

public class SalaryInfo {
	private int id;
	private String stuffID;
	private String stuffName;
	private String stuffDepart;
	private String stuffDuty;
	private double basicSalary;
	private double delSalary;
	private double addSalary;
	private double accountAwce;
	private double fSalary;
	

	public double getfSalary() {
		return fSalary;
	}

	public void setfSalary(double fSalary) {
		this.fSalary = fSalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuffID() {
		return stuffID;
	}

	public void setStuffID(String stuffID) {
		this.stuffID = stuffID;
	}

	public String getStuffName() {
		return stuffName;
	}

	public void setStuffName(String stuffName) {
		this.stuffName = stuffName;
	}

	public String getStuffDepart() {
		return stuffDepart;
	}

	public void setStuffDepart(String stuffDepart) {
		this.stuffDepart = stuffDepart;
	}

	public String getStuffDuty() {
		return stuffDuty;
	}

	public void setStuffDuty(String stuffDuty) {
		this.stuffDuty = stuffDuty;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getDelSalary() {
		return delSalary;
	}

	public void setDelSalary(double delSalary) {
		this.delSalary = delSalary;
	}

	public double getAddSalary() {
		return addSalary;
	}

	public void setAddSalary(double addSalary) {
		this.addSalary = addSalary;
	}

	public double getAccountAwce() {
		return accountAwce;
	}

	public void setAccountAwce(double accountAwce) {
		this.accountAwce = accountAwce;
	}

	

	public SalaryInfo(int id, String stuffID, String stuffName,
			String stuffDepart, String stuffDuty, double basicSalary,
			double delSalary, double addSalary, double accountAwce,
			double fSalary) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.stuffDuty = stuffDuty;
		this.basicSalary = basicSalary;
		this.delSalary = delSalary;
		this.addSalary = addSalary;
		this.accountAwce = accountAwce;
		this.fSalary = fSalary;
	}

	public SalaryInfo(String stuffID, String stuffName, String stuffDepart,
			String stuffDuty, double basicSalary, double delSalary,
			double addSalary, double accountAwce, double fSalary) {
		super();
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.stuffDuty = stuffDuty;
		this.basicSalary = basicSalary;
		this.delSalary = delSalary;
		this.addSalary = addSalary;
		this.accountAwce = accountAwce;
		this.fSalary = fSalary;
	}

	public SalaryInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
