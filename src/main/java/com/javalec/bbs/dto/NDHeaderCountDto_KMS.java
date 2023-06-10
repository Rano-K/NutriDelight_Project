package com.javalec.bbs.dto;

public class NDHeaderCountDto_KMS {

	String userid;
	String pcode;
	String count;
	String pirce;
	
	
	//Constructor
	public NDHeaderCountDto_KMS() {
		// TODO Auto-generated constructor stub
	}

	//heart count
	public NDHeaderCountDto_KMS(String userid, String pcode) {
		super();
		this.userid = userid;
		this.pcode = pcode;
	}
	
	
	
	
	
	//getter and setter
	public String getUserid() {
		return userid;
	}


	

	

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	
	
	
}
