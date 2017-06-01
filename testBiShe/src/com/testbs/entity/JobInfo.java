package com.testbs.entity;

import java.util.Date;

public class JobInfo {
    private int id;
    private String stuffID;
    private String stuffName;
	private String stuffDepart;
	private String stuffDuty;
	private String stuffStatus;
	private String stuffEntryDate;
	private String contractBegin;
	private String contractEnd;
	private double stuffMoney;
	private String adjustJob;
	private String adjustMoney;
	
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
	public String getStuffStatus() {
		return stuffStatus;
	}
	public void setStuffStatus(String stuffStatus) {
		this.stuffStatus = stuffStatus;
	}
	public String getStuffEntryDate() {
		return stuffEntryDate;
	}
	public void setStuffEntryDate(String stuffEntryDate) {
		this.stuffEntryDate = stuffEntryDate;
	}
	public String getContractBegin() {
		return contractBegin;
	}
	public void setContractBegin(String contractBegin) {
		this.contractBegin = contractBegin;
	}
	public String getContractEnd() {
		return contractEnd;
	}
	public void setContractEnd(String contractEnd) {
		this.contractEnd = contractEnd;
	}
	public double getStuffMoney() {
		return stuffMoney;
	}
	public void setStuffMoney(double stuffMoney) {
		this.stuffMoney = stuffMoney;
	}
	public String getAdjustJob() {
		return adjustJob;
	}
	public void setAdjustJob(String adjustJob) {
		this.adjustJob = adjustJob;
	}
	public String getAdjustMoney() {
		return adjustMoney;
	}
	public void setAdjustMoney(String adjustMoney) {
		this.adjustMoney = adjustMoney;
	}
	public JobInfo(int id, String stuffID, String stuffName,
			String stuffDepart, String stuffDuty, String stuffStatus,
			String stuffEntryDate, String contractBegin, String contractEnd,
			double stuffMoney, String adjustJob, String adjustMoney) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.stuffDuty = stuffDuty;
		this.stuffStatus = stuffStatus;
		this.stuffEntryDate = stuffEntryDate;
		this.contractBegin = contractBegin;
		this.contractEnd = contractEnd;
		this.stuffMoney = stuffMoney;
		this.adjustJob = adjustJob;
		this.adjustMoney = adjustMoney;
	}
	


	
	
	
	
	
	public JobInfo(String stuffID, String stuffName, String stuffDepart,
			String stuffDuty, String stuffStatus, double stuffMoney,
			String adjustJob, String adjustMoney) {
		super();
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.stuffDuty = stuffDuty;
		this.stuffStatus = stuffStatus;
		this.stuffMoney = stuffMoney;
		this.adjustJob = adjustJob;
		this.adjustMoney = adjustMoney;
	}
	
	
	
	
	public JobInfo(int id, String stuffID, String stuffDepart, String stuffDuty,
			String stuffStatus, String contractBegin, String contractEnd,
			double stuffMoney, String adjustJob, String adjustMoney) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffDepart = stuffDepart;
		this.stuffDuty = stuffDuty;
		this.stuffStatus = stuffStatus;
		this.contractBegin = contractBegin;
		this.contractEnd = contractEnd;
		this.stuffMoney = stuffMoney;
		this.adjustJob = adjustJob;
		this.adjustMoney = adjustMoney;
	}
	public JobInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
