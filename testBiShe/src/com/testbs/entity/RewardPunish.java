package com.testbs.entity;

public class RewardPunish {
	private int id;
	private String stuffID;
	private String stuffName;
	private String stuffDepart;
	private String happenDate;
	private String happenType;
	private String happenReason;
	private double changeMoney;

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

	public String getHappenDate() {
		return happenDate;
	}

	public void setHappenDate(String happenDate) {
		this.happenDate = happenDate;
	}

	public String getHappenType() {
		return happenType;
	}

	public void setHappenType(String happenType) {
		this.happenType = happenType;
	}

	public String getHappenReason() {
		return happenReason;
	}

	public void setHappenReason(String happenReason) {
		this.happenReason = happenReason;
	}

	public double getChangeMoney() {
		return changeMoney;
	}

	public void setChangeMoney(double changeMoney) {
		this.changeMoney = changeMoney;
	}

	public RewardPunish(int id, String stuffID, String stuffName,
			String stuffDepart, String happenDate, String happenType,
			String happenReason, double changeMoney) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.happenDate = happenDate;
		this.happenType = happenType;
		this.happenReason = happenReason;
		this.changeMoney = changeMoney;
	}

	public RewardPunish(String stuffName, String stuffDepart,
			String happenDate, String happenType, String happenReason,
			double changeMoney) {
		super();
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.happenDate = happenDate;
		this.happenType = happenType;
		this.happenReason = happenReason;
		this.changeMoney = changeMoney;
	}

	public RewardPunish(String stuffID, String stuffName, String stuffDepart,
			String happenDate, String happenType, String happenReason,
			double changeMoney) {
		super();
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.happenDate = happenDate;
		this.happenType = happenType;
		this.happenReason = happenReason;
		this.changeMoney = changeMoney;
	}

	public RewardPunish() {
		super();
		// TODO Auto-generated constructor stub
	}

}
