package com.javalec.bbs.dto;

public class NDUserOrdersDto_LYJ {


	String pcode;
	String name;
	String telno;
	String address;
	String email;
	String photo;
	int price;
	String count;

	
	
	public NDUserOrdersDto_LYJ() {
		// TODO Auto-generated constructor stub
	}

	
	
	




	public NDUserOrdersDto_LYJ(String name, String photo, int price, String count) {
		super();
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.count = count;
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


	
	

	public String getCount() {
		return count;
	}








	public void setCount(String count) {
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

	public String getPcode() {
		return pcode;
	}


	public void setPcode(String pcode) {
		this.pcode = pcode;
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



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}








	


	
	
}
