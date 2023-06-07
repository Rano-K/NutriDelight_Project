package com.javalec.bbs.dto;

public class NDReviewDto_KMJ {
	
	int likes;
	String userid;
	String contexts;
	String insertdate;
	String updatedate;
	

	int layer;
	int parent;
	
	String adminid;
	
	String name;
	String image;
	
	public NDReviewDto_KMJ() {
		// TODO Auto-generated constructor stub
	}
		
	public NDReviewDto_KMJ(String userid, int likes, String contexts, String insertdate, String updatedate, String image, int parent, int layer) {
		super();
		this.userid = userid;
		this.likes = likes;
		this.contexts = contexts;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.image = image;
		this.parent = parent;
		this.layer = layer;
	}
	

	public NDReviewDto_KMJ(String name, String image) {
		super();
		this.name = name;
		this.image = image;
	}


	
	public String getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
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
