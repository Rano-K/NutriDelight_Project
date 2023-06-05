package com.javalec.bbs.dto;

public class NDReviewDto_KMJ {
	
	int likes;
	String userid;
	String contexts;
	String date;
	
	String name;
	String image;
	
	public NDReviewDto_KMJ() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public NDReviewDto_KMJ(String userid, int likes, String contexts, String date, String image) {
		super();
		this.userid = userid;
		this.likes = likes;
		this.contexts = contexts;
		this.date = date;
		this.image = image;
	}


	

	public NDReviewDto_KMJ(String name, String image) {
		super();
		this.name = name;
		this.image = image;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getContexts() {
		return contexts;
	}

	public void setContexts(String contexts) {
		this.contexts = contexts;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
