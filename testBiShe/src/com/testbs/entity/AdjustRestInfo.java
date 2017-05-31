package com.testbs.entity;

public class AdjustRestInfo {
	private int id;
	private String stuffID;
	private String stuffName;
	private String stuffDepart;
	private String adjustType;
	private String adjustBefore;
	private String adjustAfter;
	private String adjustApprover;

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

	public String getAdjustType() {
		return adjustType;
	}

	public void setAdjustType(String adjustType) {
		this.adjustType = adjustType;
	}

	public String getAdjustBefore() {
		return adjustBefore;
	}

	public void setAdjustBefore(String adjustBefore) {
		this.adjustBefore = adjustBefore;
	}

	public String getAdjustAfter() {
		return adjustAfter;
	}

	public void setAdjustAfter(String adjustAfter) {
		this.adjustAfter = adjustAfter;
	}

	public String getAdjustApprover() {
		return adjustApprover;
	}

	public void setAdjustApprover(String adjustApprover) {
		this.adjustApprover = adjustApprover;
	}

	public AdjustRestInfo(int id, String stuffID, String stuffName,
			String stuffDepart, String adjustType, String adjustBefore,
			String adjustAfter, String adjustApprover) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.adjustType = adjustType;
		this.adjustBefore = adjustBefore;
		this.adjustAfter = adjustAfter;
		this.adjustApprover = adjustApprover;
	}

	public AdjustRestInfo(String stuffName, String stuffDepart,
			String adjustType, String adjustBefore, String adjustAfter,
			String adjustApprover) {
		super();
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.adjustType = adjustType;
		this.adjustBefore = adjustBefore;
		this.adjustAfter = adjustAfter;
		this.adjustApprover = adjustApprover;
	}

	public AdjustRestInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
