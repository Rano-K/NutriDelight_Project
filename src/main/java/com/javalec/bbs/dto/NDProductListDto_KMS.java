package com.javalec.bbs.dto;


public class NDProductListDto_KMS {
	String pcode;//product 테이블
	String name;//product 테이블
	int price;//manage 테이블
	String photo;
	
	
	//constructor
	public NDProductListDto_KMS() {
		// TODO Auto-generated constructor stub
	}


	public NDProductListDto_KMS(String pcode, String name, int price, String photo) {
		super();
		this.pcode = pcode;
		this.name = name;
		this.price = price;
		this.photo = photo;
	}
	
	


	public NDProductListDto_KMS(String photo) {
		super();
		this.photo = photo;
	}


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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}

	

	

	
}//End
