package com.testbs.entity;

public class RetireInfo {
	private int id;
	private String stuffID;
	private String stuffName;
	private String stuffDepart;
	private String stuffDuty;
	private String stuffEntryDate;
	private String retireDate;
	private String retireInterface;
	private double retireMoney;

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

	public String getStuffEntryDate() {
		return stuffEntryDate;
	}

	public void setStuffEntryDate(String stuffEntryDate) {
		this.stuffEntryDate = stuffEntryDate;
	}

	public String getRetireDate() {
		return retireDate;
	}

	public void setRetireDate(String retireDate) {
		this.retireDate = retireDate;
	}

	public String getRetireInterface() {
		return retireInterface;
	}

	public void setRetireInterface(String retireInterface) {
		this.retireInterface = retireInterface;
	}

	public double getRetireMoney() {
		return retireMoney;
	}

	public void setRetireMoney(double retireMoney) {
		this.retireMoney = retireMoney;
	}

	public RetireInfo(int id, String stuffID, String stuffName,
			String stuffDepart, String stuffDuty, String stuffEntryDate,
			String retireDate, String retireInterface, double retireMoney) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.stuffDuty = stuffDuty;
		this.stuffEntryDate = stuffEntryDate;
		this.retireDate = retireDate;
		this.retireInterface = retireInterface;
		this.retireMoney = retireMoney;
	}

	public RetireInfo(String stuffName, String stuffDepart, String stuffDuty,
			String stuffEntryDate, String retireDate, String retireInterface,
			double retireMoney) {
		super();
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.stuffDuty = stuffDuty;
		this.stuffEntryDate = stuffEntryDate;
		this.retireDate = retireDate;
		this.retireInterface = retireInterface;
		this.retireMoney = retireMoney;
	}

	public RetireInfo(String stuffID, String stuffName, String stuffDepart,
			String stuffDuty, String stuffEntryDate, String retireDate,
			String retireInterface, double retireMoney) {
		super();
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.stuffDuty = stuffDuty;
		this.stuffEntryDate = stuffEntryDate;
		this.retireDate = retireDate;
		this.retireInterface = retireInterface;
		this.retireMoney = retireMoney;
	}

	public RetireInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
