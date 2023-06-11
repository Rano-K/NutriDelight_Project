package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDNoticeDto_OKH {
	//	Fields
	int seq;
	String adminid;
	Timestamp insertdate;
	int invalidate;
	String title;
	String context;
	Timestamp updatedate;
	
	//Fields
	public NDNoticeDto_OKH() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public NDNoticeDto_OKH(int seq, String adminid, Timestamp insertdate, int invalidate, String title, String context,
			Timestamp updatedate) {
		super();
		this.seq = seq;
		this.adminid = adminid;
		this.insertdate = insertdate;
		this.invalidate = invalidate;
		this.title = title;
		this.context = context;
		this.updatedate = updatedate;
	}


	//	Method G/S


	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public Timestamp getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(Timestamp insertdate) {
		this.insertdate = insertdate;
	}

	public int getInvalidate() {
		return invalidate;
	}

	public void setInvalidate(int invalidate) {
		this.invalidate = invalidate;
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

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	
	
	
	
}
