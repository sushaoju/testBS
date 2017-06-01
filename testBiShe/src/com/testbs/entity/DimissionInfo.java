package com.testbs.entity;

public class DimissionInfo {
	private int id;
	private String stuffID;
	private String stuffName;
	private String stuffDepart;
	private String stuffDuty;
	private String dimissInterface;
	private String dimissReason;
	private String dimissDate;

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

	public String getDimissInterface() {
		return dimissInterface;
	}

	public void setDimissInterface(String dimissInterface) {
		this.dimissInterface = dimissInterface;
	}

	public String getDimissReason() {
		return dimissReason;
	}

	public void setDimissReason(String dimissReason) {
		this.dimissReason = dimissReason;
	}

	public String getDimissDate() {
		return dimissDate;
	}

	public void setDimissDate(String dimissDate) {
		this.dimissDate = dimissDate;
	}

	public DimissionInfo(int id, String stuffID, String stuffName,
			String stuffDepart, String stuffDuty, String dimissInterface,
			String dimissReason, String dimissDate) {
		super();
		this.id = id;
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.stuffDuty = stuffDuty;
		this.dimissInterface = dimissInterface;
		this.dimissReason = dimissReason;
		this.dimissDate = dimissDate;
	}

	public DimissionInfo(String stuffName, String stuffDepart,
			String stuffDuty, String dimissInterface, String dimissReason,
			String dimissDate) {
		super();
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.stuffDuty = stuffDuty;
		this.dimissInterface = dimissInterface;
		this.dimissReason = dimissReason;
		this.dimissDate = dimissDate;
	}

	public DimissionInfo(String stuffID, String stuffName, String stuffDepart,
			String stuffDuty, String dimissInterface, String dimissReason,
			String dimissDate) {
		super();
		this.stuffID = stuffID;
		this.stuffName = stuffName;
		this.stuffDepart = stuffDepart;
		this.stuffDuty = stuffDuty;
		this.dimissInterface = dimissInterface;
		this.dimissReason = dimissReason;
		this.dimissDate = dimissDate;
	}

	public DimissionInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
