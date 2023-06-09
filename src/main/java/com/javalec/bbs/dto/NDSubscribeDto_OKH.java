package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDSubscribeDto_OKH {
	// Fields
	int scode;
	String userid;
	Timestamp subscribedate;

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

	public Timestamp getSubscribedate() {
		return subscribedate;
	}

	public void setSubscribedate(Timestamp subscribedate) {
		this.subscribedate = subscribedate;
	}

}
