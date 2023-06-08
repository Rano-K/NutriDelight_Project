package com.javalec.bbs.dto;

public class NDQuestionDto_KMJ {
	String userid;
	int layer;
	String image;
	String title;
	String context;
	String insertdate;
	String updatedate;
	
	public NDQuestionDto_KMJ() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public NDQuestionDto_KMJ(String userid, int layer, String image, String title, String context, String insertdate,
			String updatedate) {
		super();
		this.userid = userid;
		this.layer = layer;
		this.image = image;
		this.title = title;
		this.context = context;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}




	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
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
	
	
}
