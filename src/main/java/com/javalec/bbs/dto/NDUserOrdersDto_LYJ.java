package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDUserOrdersDto_LYJ {

	int ordercode;
	String userid;
	String pcode;
	String photo;
	String name;
	String email;
	
	Timestamp orderdate;
	Timestamp refunddate;
	Timestamp deliverydate;
	
	String userid1;
	String uname;
	String telno;
	String address;
	String pname;
	int price;
	String count;
	
	
	
	public NDUserOrdersDto_LYJ() {
		// TODO Auto-generated constructor stub
	}

	
	
	




	public NDUserOrdersDto_LYJ(String name, String telno, String address, String email) {
		super();
		this.name = name;
		this.telno = telno;
		this.address = address;
		this.email = email;
	}








	public NDUserOrdersDto_LYJ(String pcode, String name, String photo,  int price) {
		super();
		this.pcode = pcode;
		this.name = name;
		this.photo = photo;
		this.price = price;
	}





/*


	public NDUserOrdersDto_LYJ(String userid1, String uname, String telno, String address) {
		super();
		this.userid1 = userid1;
		this.uname = uname;
		this.telno = telno;
		this.address = address;
	}


*/





	public NDUserOrdersDto_LYJ(String userid1, String uname, String telno, String address, String pname, int price, String count) {
		super();
		this.userid1 = userid1;
		this.uname = uname;
		this.telno = telno;
		this.address = address;
		this.pname = pname;
		this.price = price;
		this.count = count;
	}








	public String getEmail() {
		return email;
	}








	public void setEmail(String email) {
		this.email = email;
	}








	public String getName() {
		return name;
	}








	public void setName(String name) {
		this.name = name;
	}








	public String getPhoto() {
		return photo;
	}








	public void setPhoto(String photo) {
		this.photo = photo;
	}








	public String getUserid1() {
		return userid1;
	}








	public void setUserid1(String userid1) {
		this.userid1 = userid1;
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








	public String getUname() {
		return uname;
	}








	public void setUname(String uname) {
		this.uname = uname;
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








	public String getPname() {
		return pname;
	}








	public void setPname(String pname) {
		this.pname = pname;
	}








	public int getPrice() {
		return price;
	}








	public void setPrice(int price) {
		this.price = price;
	}








	public String getCount() {
		return count;
	}








	public void setCount(String count) {
		this.count = count;
	}









	
	
}
