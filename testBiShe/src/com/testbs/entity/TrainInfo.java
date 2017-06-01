package com.testbs.entity;

public class TrainInfo {
	private int id;
	private String stuffID;
	private String stuffName;
	private String stuffDepart;
	private String trainType;
	private String trainBegin;
	private String trainEnd;
	private String trainTeacher;
	private String trainResult;

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

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public String getTrainBegin() {
		return trainBegin;
	}

	public void setTrainBegin(String trainBegin) {
		this.trainBegin = trainBegin;
	}

	public String getTrainEnd() {
		return trainEnd;
	}

	public void setTrainEnd(String trainEnd) {
		this.trainEnd = trainEnd;
	}

	public String getTrainTeacher() {
		return trainTeacher;
	}

	public void setTrainTeacher(String trainTeacher) {
		this.trainTeacher = trainTeacher;
	}

	public String getTrainResult() {
		return trainResult;
	}

	public void setTrainResult(String trainResult) {
		this.trainResult = trainResult;
	}

	public TrainInfo(int id, String stuffID, String stuffName,
			String stuffDepart, String trainType, String trainBegin,
			String trainEnd, String trainTeacher, String trainResult) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.trainType = trainType;
		this.trainBegin = trainBegin;
		this.trainEnd = trainEnd;
		this.trainTeacher = trainTeacher;
		this.trainResult = trainResult;
	}

	public TrainInfo(String stuffName, String stuffDepart, String trainType,
			String trainBegin, String trainEnd, String trainTeacher,
			String trainResult) {
		super();
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.trainType = trainType;
		this.trainBegin = trainBegin;
		this.trainEnd = trainEnd;
		this.trainTeacher = trainTeacher;
		this.trainResult = trainResult;
	}

	public TrainInfo(String stuffID, String stuffName, String stuffDepart,
			String trainType, String trainBegin, String trainEnd,
			String trainTeacher, String trainResult) {
		super();
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.trainType = trainType;
		this.trainBegin = trainBegin;
		this.trainEnd = trainEnd;
		this.trainTeacher = trainTeacher;
		this.trainResult = trainResult;
	}

	public TrainInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
