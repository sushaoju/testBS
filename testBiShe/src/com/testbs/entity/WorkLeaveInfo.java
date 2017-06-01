package com.testbs.entity;

public class WorkLeaveInfo {
	private int id;
	private String stuffID;
	private String stuffName;
	private String stuffDepart;
	private String leaveBegin;
	private String leaveEnd;
	private double leaveHours;
	private String leaveType;
	private String leaveReason;
	private String approver;
	private double leaveMoney;

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

	public String getLeaveBegin() {
		return leaveBegin;
	}

	public void setLeaveBegin(String leaveBegin) {
		this.leaveBegin = leaveBegin;
	}

	public String getLeaveEnd() {
		return leaveEnd;
	}

	public void setLeaveEnd(String leaveEnd) {
		this.leaveEnd = leaveEnd;
	}

	public double getLeaveHours() {
		return leaveHours;
	}

	public void setLeaveHours(double leaveHours) {
		this.leaveHours = leaveHours;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public double getLeaveMoney() {
		return leaveMoney;
	}

	public void setLeaveMoney(double leaveMoney) {
		this.leaveMoney = leaveMoney;
	}

	public WorkLeaveInfo(int id, String stuffID, String stuffName,
			String stuffDepart, String leaveBegin, String leaveEnd,
			double leaveHours, String leaveType, String leaveReason,
			String approver, double leaveMoney) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.leaveBegin = leaveBegin;
		this.leaveEnd = leaveEnd;
		this.leaveHours = leaveHours;
		this.leaveType = leaveType;
		this.leaveReason = leaveReason;
		this.approver = approver;
		this.leaveMoney = leaveMoney;
	}

	public WorkLeaveInfo(String stuffName, String stuffDepart,
			String leaveBegin, String leaveEnd, double leaveHours,
			String leaveType, String leaveReason, String approver,
			double leaveMoney) {
		super();
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.leaveBegin = leaveBegin;
		this.leaveEnd = leaveEnd;
		this.leaveHours = leaveHours;
		this.leaveType = leaveType;
		this.leaveReason = leaveReason;
		this.approver = approver;
		this.leaveMoney = leaveMoney;
	}

	public WorkLeaveInfo(String stuffID, String stuffName, String stuffDepart,
			String leaveBegin, String leaveEnd, double leaveHours,
			String leaveReason, String approver, double leaveMoney) {
		super();
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.leaveBegin = leaveBegin;
		this.leaveEnd = leaveEnd;
		this.leaveHours = leaveHours;
		this.leaveReason = leaveReason;
		this.approver = approver;
		this.leaveMoney = leaveMoney;
	}

	public WorkLeaveInfo(String stuffID, String stuffName, String stuffDepart,
			String leaveBegin, String leaveEnd, double leaveHours,
			String leaveType, String leaveReason, String approver,
			double leaveMoney) {
		super();
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.leaveBegin = leaveBegin;
		this.leaveEnd = leaveEnd;
		this.leaveHours = leaveHours;
		this.leaveType = leaveType;
		this.leaveReason = leaveReason;
		this.approver = approver;
		this.leaveMoney = leaveMoney;
	}

	public WorkLeaveInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
