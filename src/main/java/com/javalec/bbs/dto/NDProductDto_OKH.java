package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDProductDto_OKH {
	//	Fields
	String pcode;
	String name;
	String category;
	String rice;
	String cook1;
	String cook2;
	String cook3;
	String soup;
	String photo;
	Timestamp insertdate;

	int totalorders;
	
	//	Constructor
	public NDProductDto_OKH() {
		// TODO Auto-generated constructor stub
	}

	public NDProductDto_OKH(String pcode, String name, String category, String rice, String cook1, String cook2,
			String cook3, String soup, String photo, Timestamp insertdate) {
		super();
		this.pcode = pcode;
		this.name = name;
		this.category = category;
		this.rice = rice;
		this.cook1 = cook1;
		this.cook2 = cook2;
		this.cook3 = cook3;
		this.soup = soup;
		this.photo = photo;
		this.insertdate = insertdate;
	}

	public NDProductDto_OKH(String name, int totalorders) {
		super();
		this.name = name;
		this.totalorders = totalorders;
	}

	
	//	Method G/S
	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRice() {
		return rice;
	}

	public void setRice(String rice) {
		this.rice = rice;
	}

	public String getCook1() {
		return cook1;
	}

	public void setCook1(String cook1) {
		this.cook1 = cook1;
	}

	public String getCook2() {
		return cook2;
	}

	public void setCook2(String cook2) {
		this.cook2 = cook2;
	}

	public String getCook3() {
		return cook3;
	}

	public void setCook3(String cook3) {
		this.cook3 = cook3;
	}

	public String getSoup() {
		return soup;
	}

	public void setSoup(String soup) {
		this.soup = soup;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Timestamp getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(Timestamp insertdate) {
		this.insertdate = insertdate;
	}

	public int getTotalorders() {
		return totalorders;
	}

	public void setTotalorders(int totalorders) {
		this.totalorders = totalorders;
	}
	

	
	
	
	
}
