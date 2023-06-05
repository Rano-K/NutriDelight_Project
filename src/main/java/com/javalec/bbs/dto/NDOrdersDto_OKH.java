package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDOrdersDto_OKH {
	// Fields
	int ordercode;
	String userid;
	String pcode;
	String address;
	int count;
	Timestamp orderdate;
	Timestamp refunddate;
	Timestamp deliverydate;
	
	int totalsales;
	String month;

	// Constructor
	public NDOrdersDto_OKH() {
		// TODO Auto-generated constructor stub
	}

	public NDOrdersDto_OKH(int ordercode, String userid, String pcode, String address, int count, Timestamp orderdate,
			Timestamp refunddate, Timestamp deliverydate) {
		super();
		this.ordercode = ordercode;
		this.userid = userid;
		this.pcode = pcode;
		this.address = address;
		this.count = count;
		this.orderdate = orderdate;
		this.refunddate = refunddate;
		this.deliverydate = deliverydate;
	}

	public NDOrdersDto_OKH(Timestamp orderdate, int count) {
		super();
		this.orderdate = orderdate;
		this.count = count;
	}

	
	public NDOrdersDto_OKH(String month, int totalsales) {
		super();
		this.totalsales = totalsales;
		this.month = month;
	}
	
	// Method G/S


	public int getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(int ordercode) {
		this.ordercode = ordercode;
	}

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Timestamp getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}

	public Timestamp getRefunddate() {
		return refunddate;
	}

	public void setRefunddate(Timestamp refunddate) {
		this.refunddate = refunddate;
	}

	public Timestamp getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(Timestamp deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTotalsales() {
		return totalsales;
	}

	public void setTotalsales(int totalsales) {
		this.totalsales = totalsales;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	
	 

}
