package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDManageDto_OKH {
	// Fields
	String adminid;
	String pcode;
	int stock;
	int price;
	Timestamp updatedate;
	int invalidate;

	// Constructor

	public NDManageDto_OKH() {
		// TODO Auto-generated constructor stub
	}

	public NDManageDto_OKH(String adminid, String pcode, int stock, int price, Timestamp updatedate, int invalidate) {
		super();
		this.adminid = adminid;
		this.pcode = pcode;
		this.stock = stock;
		this.price = price;
		this.updatedate = updatedate;
		this.invalidate = invalidate;
	}

	public NDManageDto_OKH(int stock) {
		super();
		this.stock = stock;
	}

	// Method G/S

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	public int getInvalidate() {
		return invalidate;
	}

	public void setInvalidate(int invalidate) {
		this.invalidate = invalidate;
	}

}
