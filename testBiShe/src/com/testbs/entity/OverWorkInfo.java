package com.testbs.entity;

public class OverWorkInfo {
	private int id;
	private String stuffID;
	private String stuffName;
	private String stuffDepart;
	private String overworkStart;
	private String overworkEnd;
	private double overworkHours;
	private String overworkReason;
	private double overworkMoney;
	private String overworkApprover;

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

	public String getOverworkStart() {
		return overworkStart;
	}

	public void setOverworkStart(String overworkStart) {
		this.overworkStart = overworkStart;
	}

	public String getOverworkEnd() {
		return overworkEnd;
	}

	public void setOverworkEnd(String overworkEnd) {
		this.overworkEnd = overworkEnd;
	}

	public double getOverworkHours() {
		return overworkHours;
	}

	public void setOverworkHours(double overworkHours) {
		this.overworkHours = overworkHours;
	}

	public String getOverworkReason() {
		return overworkReason;
	}

	public void setOverworkReason(String overworkReason) {
		this.overworkReason = overworkReason;
	}

	public double getOverworkMoney() {
		return overworkMoney;
	}

	public void setOverworkMoney(double overworkMoney) {
		this.overworkMoney = overworkMoney;
	}

	public String getOverworkApprover() {
		return overworkApprover;
	}

	public void setOverworkApprover(String overworkApprover) {
		this.overworkApprover = overworkApprover;
	}

	public OverWorkInfo(int id, String stuffID, String stuffName,
			String stuffDepart, String overworkStart, String overworkEnd,
			double overworkHours, String overworkReason, double overworkMoney,
			String overworkApprover) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.overworkStart = overworkStart;
		this.overworkEnd = overworkEnd;
		this.overworkHours = overworkHours;
		this.overworkReason = overworkReason;
		this.overworkMoney = overworkMoney;
		this.overworkApprover = overworkApprover;
	}

	public OverWorkInfo(String stuffName, String stuffDepart,
			String overworkStart, String overworkEnd, double overworkHours,
			String overworkReason, double overworkMoney, String overworkApprover) {
		super();
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.overworkStart = overworkStart;
		this.overworkEnd = overworkEnd;
		this.overworkHours = overworkHours;
		this.overworkReason = overworkReason;
		this.overworkMoney = overworkMoney;
		this.overworkApprover = overworkApprover;
	}

	public OverWorkInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
