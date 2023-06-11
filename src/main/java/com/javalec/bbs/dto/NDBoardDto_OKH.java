package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class NDBoardDto_OKH {
	//	Fields
	int seq;
	int parent;
	int layer;
	String userid;
	String pcode;
	String adminid;
	Timestamp insertdate;
	int invalidate;
	String bwtitle;
	String bwcontext;
	String bwimage;
	Timestamp bwupdatedate;
	String brtitle;
	String brcontext;
	Timestamp brupdatedate;
	
	//	Constructor
	public NDBoardDto_OKH() {
		// TODO Auto-generated constructor stub
	}

	public NDBoardDto_OKH(int seq, int parent, int layer, String userid, String pcode, String adminid,
			Timestamp insertdate, int invalidate, String bwtitle, String bwcontext, String bwimage,
			Timestamp bwupdatedate, String brtitle, String brcontext, Timestamp brupdatedate) {
		super();
		this.seq = seq;
		this.parent = parent;
		this.layer = layer;
		this.userid = userid;
		this.pcode = pcode;
		this.adminid = adminid;
		this.insertdate = insertdate;
		this.invalidate = invalidate;
		this.bwtitle = bwtitle;
		this.bwcontext = bwcontext;
		this.bwimage = bwimage;
		this.bwupdatedate = bwupdatedate;
		this.brtitle = brtitle;
		this.brcontext = brcontext;
		this.brupdatedate = brupdatedate;
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

	public String getBwtitle() {
		return bwtitle;
	}

	public void setBwtitle(String bwtitle) {
		this.bwtitle = bwtitle;
	}

	public String getBwcontext() {
		return bwcontext;
	}

	public void setBwcontext(String bwcontext) {
		this.bwcontext = bwcontext;
	}

	public String getBwimage() {
		return bwimage;
	}

	public void setBwimage(String bwimage) {
		this.bwimage = bwimage;
	}

	public Timestamp getBwupdatedate() {
		return bwupdatedate;
	}

	public void setBwupdatedate(Timestamp bwupdatedate) {
		this.bwupdatedate = bwupdatedate;
	}

	public String getBrtitle() {
		return brtitle;
	}

	public void setBrtitle(String brtitle) {
		this.brtitle = brtitle;
	}

	public String getBrcontext() {
		return brcontext;
	}

	public void setBrcontext(String brcontext) {
		this.brcontext = brcontext;
	}

	public Timestamp getBrupdatedate() {
		return brupdatedate;
	}

	public void setBrupdatedate(Timestamp brupdatedate) {
		this.brupdatedate = brupdatedate;
	}
	
	
	
	
	
}
