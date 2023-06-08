package com.javalec.bbs.dto;

public class NDNoticeDto_KMJ {
	String id;
	String title;
	String context;
	String insertdate;
	String updatedate;
	
	public NDNoticeDto_KMJ() {
		// TODO Auto-generated constructor stub
	}
	
	
	public NDNoticeDto_KMJ(String id, String title, String context, String insertdate, String updatedate) {
		super();
		this.id = id;
		this.title = title;
		this.context = context;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
