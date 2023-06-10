package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDPlanDto_OKH {
	// Fields
	int plcode;
	String pcode;
	int scode;
	Timestamp plandate;
	int delivery;
	Timestamp deliverydate;

	String name;

	// Constructor

	public NDPlanDto_OKH() {
		// TODO Auto-generated constructor stub
	}

	public NDPlanDto_OKH(int plcode, String pcode, int scode, Timestamp plandate, int delivery) {
		super();
		this.plcode = plcode;
		this.pcode = pcode;
		this.scode = scode;
		this.plandate = plandate;
		this.delivery = delivery;
	}

	public NDPlanDto_OKH(int plcode, Timestamp deliverydate) {
		super();
		this.plcode = plcode;
		this.deliverydate = deliverydate;
	}

	public NDPlanDto_OKH(String name) {
		super();
		this.name = name;
	}

	// Method G/S

	public int getPlcode() {
		return plcode;
	}

	public void setPlcode(int plcode) {
		this.plcode = plcode;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public int getScode() {
		return scode;
	}

	public void setScode(int scode) {
		this.scode = scode;
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

	public Timestamp getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(Timestamp deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
