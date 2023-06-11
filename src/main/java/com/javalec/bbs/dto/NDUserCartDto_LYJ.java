package com.javalec.bbs.dto;

public class NDUserCartDto_LYJ {

	String userid;
	String userid1;
	int seq;
	String pcode;
	String photo;
	String name;
	int price;
	String count;
	
	public NDUserCartDto_LYJ() {
		// TODO Auto-generated constructor stub
	}

	

	public NDUserCartDto_LYJ(String userid1, int seq, String pcode, String photo, String name, int price, String count ) {
	    super();
	    this.userid1 = userid1;
	    this.seq = seq;
	    this.pcode = pcode;
	    this.photo = photo;
	    this.name = name;
	    this.price = price;
	    this.count = count;
	}

	public String getUserid1() {
		return userid1;
	}



	public void setUserid1(String userid1) {
		this.userid1 = userid1;
	}



	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
