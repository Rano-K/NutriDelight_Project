package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDLoginDto {
	// Field
	String userid;
	String userpw;
	String name;
	String gender;
	String age;
	String telno;
	String email;
	String address;
	String allergy;
	Timestamp insertdate;
	int invalidate;
	
	
	// Constructor
	public NDLoginDto() {
		// TODO Auto-generated constructor stub
	}

	

	public NDLoginDto(String name, String age, String telno, String email, String address, String allergy) {
		super();
		this.name = name;
		this.age = age;
		this.telno = telno;
		this.email = email;
		this.address = address;
		this.allergy = allergy;
	}



	public NDLoginDto(String userid, String userpw, String name, String gender, String age, String telno, String email, String address,
			String allergy) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.telno = telno;
		this.email = email;
		this.address = address;
		this.allergy = allergy;
	}

	
	public NDLoginDto(String name, String gender, String age, String telno, String email, String address,
			String allergy) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.telno = telno;
		this.email = email;
		this.address = address;
		this.allergy = allergy;
	}


	// Method
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


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getTelno() {
		return telno;
	}


	public void setTelno(String telno) {
		this.telno = telno;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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
}
