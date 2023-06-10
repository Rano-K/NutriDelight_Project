package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDSubscribeDto_OKH {
	// Fields
	int scode;
	String userid;
	Timestamp subscribedate;
	
	Timestamp plandate;
	int delivery;
	String uname;
	String pname;
	String address;
	int plcode;
	

	// Constructor
	public NDSubscribeDto_OKH() {
		// TODO Auto-generated constructor stub
	}

	public NDSubscribeDto_OKH(int scode, String userid, Timestamp subscribedate) {
		super();
		this.scode = scode;
		this.userid = userid;
		this.subscribedate = subscribedate;
	}
	
	
	
	//	Method G/S

	public NDSubscribeDto_OKH(int plcode, String userid, int scode, Timestamp plandate, int delivery, String uname, String pname,
			String address) {
		super();
		this.plcode = plcode;
		this.userid = userid;
		this.scode = scode;
		this.plandate = plandate;
		this.delivery = delivery;
		this.uname = uname;
		this.pname = pname;
		this.address = address;
	}

	public Timestamp getPlandate() {
		return plandate;
	}

	public void setPlandate(Timestamp plandate) {
		this.plandate = plandate;
	}

	public int getDelivery() {
		return delivery;
	}

	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public int getScode() {
		return scode;
	}

	public void setScode(int scode) {
		this.scode = scode;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getPlcode() {
		return plcode;
	}

	public void setPlcode(int plcode) {
		this.plcode = plcode;
	}

	public Timestamp getSubscribedate() {
		return subscribedate;
	}

	public void setSubscribedate(Timestamp subscribedate) {
		this.subscribedate = subscribedate;
	}

}
