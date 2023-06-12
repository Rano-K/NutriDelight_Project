package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDUserOrdersDto {
	// orders
	int ordercode;
	String userid;
	String pcode;
	String address;
	int count;
	Timestamp orderdate;
	Timestamp refunddate;
	Timestamp deliverydate;
	
	// subscribes
	int scode;
	Timestamp subscribedate;
	
	// plans
	String plcode;
	String ppcode;
	int pscode;
	Timestamp plandate;
	int delivery;
	
	// product
	String photo;
	String name;
	
	// manage
	int price;
	
	
	public NDUserOrdersDto() {
		// TODO Auto-generated constructor stub
	}


	public NDUserOrdersDto(int ordercode, int count, Timestamp orderdate, Timestamp refunddate, Timestamp deliverydate,
			String photo, String name, int price, String pcode) {
		super();
		this.ordercode = ordercode;
		this.count = count;
		this.orderdate = orderdate;
		this.refunddate = refunddate;
		this.deliverydate = deliverydate;
		this.photo = photo;
		this.name = name;
		this.price = price;
		this.pcode = pcode;
	}

	

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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public int getScode() {
		return scode;
	}


	public void setScode(int scode) {
		this.scode = scode;
	}


	public Timestamp getSubscribedate() {
		return subscribedate;
	}


	public void setSubscribedate(Timestamp subscribedate) {
		this.subscribedate = subscribedate;
	}


	public String getPlcode() {
		return plcode;
	}


	public void setPlcode(String plcode) {
		this.plcode = plcode;
	}


	public String getPpcode() {
		return ppcode;
	}


	public void setPpcode(String ppcode) {
		this.ppcode = ppcode;
	}


	public int getPscode() {
		return pscode;
	}


	public void setPscode(int pscode) {
		this.pscode = pscode;
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


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
}
