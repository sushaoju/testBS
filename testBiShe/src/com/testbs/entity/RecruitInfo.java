package com.testbs.entity;

public class RecruitInfo {
	private int id;
	private String demandJob;
	private int demandNum;
	private int existNum;
	private String jobRequest;
	private String arrivalDate;
	private String recruitStatus;
	private String applycant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDemandJob() {
		return demandJob;
	}

	public void setDemandJob(String demandJob) {
		this.demandJob = demandJob;
	}

	public int getDemandNum() {
		return demandNum;
	}

	public void setDemandNum(int demandNum) {
		this.demandNum = demandNum;
	}

	public int getExistNum() {
		return existNum;
	}

	public void setExistNum(int existNum) {
		this.existNum = existNum;
	}

	public String getJobRequest() {
		return jobRequest;
	}

	public void setJobRequest(String jobRequest) {
		this.jobRequest = jobRequest;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getRecruitStatus() {
		return recruitStatus;
	}

	public void setRecruitStatus(String recruitStatus) {
		this.recruitStatus = recruitStatus;
	}

	public String getApplycant() {
		return applycant;
	}

	public void setApplycant(String applycant) {
		this.applycant = applycant;
	}

	public RecruitInfo(int id, String demandJob, int demandNum, int existNum,
			String jobRequest, String arrivalDate, String recruitStatus,
			String applycant) {
		super();
		this.id = id;
		this.demandJob = demandJob;
		this.demandNum = demandNum;
		this.existNum = existNum;
		this.jobRequest = jobRequest;
		this.arrivalDate = arrivalDate;
		this.recruitStatus = recruitStatus;
		this.applycant = applycant;
	}

	public RecruitInfo(String demandJob, int demandNum, int existNum,
			String jobRequest, String arrivalDate, String recruitStatus,
			String applycant) {
		super();
		this.demandJob = demandJob;
		this.demandNum = demandNum;
		this.existNum = existNum;
		this.jobRequest = jobRequest;
		this.arrivalDate = arrivalDate;
		this.recruitStatus = recruitStatus;
		this.applycant = applycant;
	}

	public RecruitInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
