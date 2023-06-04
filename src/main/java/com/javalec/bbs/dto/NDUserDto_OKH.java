package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDUserDto_OKH {
	//	Fields
	String userid;
	String userpw;
	String name;
	String gender;
	Timestamp birthdate;
	String telno;
	String address;
	String email;
	String allergy;
	Timestamp insertdate;
	int invalidate;
	
	int totalbuying;
	
	//	Constructor
	public NDUserDto_OKH() {
		// TODO Auto-generated constructor stub
	}

	public NDUserDto_OKH(String userid, String userpw, String name, String gender, Timestamp birthdate, String telno, String address, String email,
			int totalbuying, String allergy, Timestamp insertdate, int invalidate ) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.telno = telno;
		this.address = address;
		this.email = email;
		this.allergy = allergy;
		this.insertdate = insertdate;
		this.invalidate = invalidate;
		this.totalbuying = totalbuying;
	}
	
	
	//	Method G/S

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public Timestamp getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(Timestamp insertdate) {
		this.insertdate = insertdate;
	}

	public int getInvalidate() {
		return invalidate;
	}

	public void setInvalidate(int invalidate) {
		this.invalidate = invalidate;
	}

	public int getTotalbuying() {
		return totalbuying;
	}

	public void setTotalbuying(int totalbuying) {
		this.totalbuying = totalbuying;
	}
	
	
	
	
}
