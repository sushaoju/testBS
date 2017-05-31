package com.testbs.entity;

public class CheckInfo {
	private int id;
	private String stuffID;
	private String stuffName;
	private String stuffDepart;
	private String stuffShift;
	private double workHour;
	private String workDate;
	private double lateHour;
	private double absentHour;

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

	public String getStuffShift() {
		return stuffShift;
	}

	public void setStuffShift(String stuffShift) {
		this.stuffShift = stuffShift;
	}

	public double getWorkHour() {
		return workHour;
	}

	public void setWorkHour(double workHour) {
		this.workHour = workHour;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public double getLateHour() {
		return lateHour;
	}

	public void setLateHour(double lateHour) {
		this.lateHour = lateHour;
	}

	public double getAbsentHour() {
		return absentHour;
	}

	public void setAbsentHour(double absentHour) {
		this.absentHour = absentHour;
	}

	public CheckInfo(String stuffName, String stuffDepart, String stuffShift,
			double workHour, String workDate, double lateHour, double absentHour) {
		super();
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.stuffShift = stuffShift;
		this.workHour = workHour;
		this.workDate = workDate;
		this.lateHour = lateHour;
		this.absentHour = absentHour;
	}

	public CheckInfo(int id, String stuffID, String stuffName,
			String stuffDepart, String stuffShift, double workHour,
			String workDate, double lateHour, double absentHour) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.stuffShift = stuffShift;
		this.workHour = workHour;
		this.workDate = workDate;
		this.lateHour = lateHour;
		this.absentHour = absentHour;
	}

	public CheckInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
