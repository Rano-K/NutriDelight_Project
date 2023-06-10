package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDReviewDto_OKH {
	//	Fields
	int seq;
	int parent;
	int layer;
	String userid;
	String pcode;
	String adminid;
	Timestamp insertdate;
	int invalidate;
	String rwcontext;
	String rwimage;
	Timestamp rwupdatedate;
	String rrcontext;
	Timestamp rrupdatedate;
	
	//	Constructor
	public NDReviewDto_OKH() {
		// TODO Auto-generated constructor stub
	}

	


	public NDReviewDto_OKH(int seq, int parent, int layer, String userid, String pcode, String adminid,
			Timestamp insertdate, int invalidate, String rwcontext, String rwimage, Timestamp rwupdatedate,
			String rrcontext, Timestamp rrupdatedate) {
		super();
		this.seq = seq;
		this.parent = parent;
		this.layer = layer;
		this.userid = userid;
		this.pcode = pcode;
		this.adminid = adminid;
		this.insertdate = insertdate;
		this.invalidate = invalidate;
		this.rwcontext = rwcontext;
		this.rwimage = rwimage;
		this.rwupdatedate = rwupdatedate;
		this.rrcontext = rrcontext;
		this.rrupdatedate = rrupdatedate;
	}



	//	Method	G/S
	
	


	public int getSeq() {
		return seq;
	}




	public void setSeq(int seq) {
		this.seq = seq;
	}




	public int getParent() {
		return parent;
	}




	public void setParent(int parent) {
		this.parent = parent;
	}




	public int getLayer() {
		return layer;
	}




	public void setLayer(int layer) {
		this.layer = layer;
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




	public String getRwcontext() {
		return rwcontext;
	}




	public void setRwcontext(String rwcontext) {
		this.rwcontext = rwcontext;
	}




	public String getRwimage() {
		return rwimage;
	}




	public void setRwimage(String rwimage) {
		this.rwimage = rwimage;
	}




	public Timestamp getRwupdatedate() {
		return rwupdatedate;
	}




	public void setRwupdatedate(Timestamp rwupdatedate) {
		this.rwupdatedate = rwupdatedate;
	}




	public String getRrcontext() {
		return rrcontext;
	}




	public void setRrcontext(String rrcontext) {
		this.rrcontext = rrcontext;
	}




	public Timestamp getRrupdatedate() {
		return rrupdatedate;
	}




	public void setRrupdatedate(Timestamp rrupdatedate) {
		this.rrupdatedate = rrupdatedate;
	}

	
}
