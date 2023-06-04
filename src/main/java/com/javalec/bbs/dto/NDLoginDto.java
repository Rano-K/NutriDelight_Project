package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDLoginDto {
	// Field
	String userid;
	String userpw;
	String name;
	String gender;
	int age;
	String telno;
	String email;
	String allergy;
	Timestamp insertdate;
	int invalidate;
	
	
	// Constructor
	public NDLoginDto() {
		// TODO Auto-generated constructor stub
	}


	public NDLoginDto(String userid, String userpw, String name, String gender, int age, String telno, String email,
			String allergy) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.telno = telno;
		this.email = email;
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
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
