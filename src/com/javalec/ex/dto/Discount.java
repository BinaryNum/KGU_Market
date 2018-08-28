package com.javalec.ex.dto;

public class Discount {

	int bId;
	int cId;
	String bName;
	String userId;
	String contents;
	int flag;
	
	public Discount() {
		// TODO Auto-generated constructor stub
	}
	
	public Discount(int cId, int bId,String bName, String userId, String contents, int flag) {
		// TODO Auto-generated constructor stub
		this.bId = bId;
		this.cId = cId;
		this.bName = bName;
		this.userId = userId;
		this.contents = contents;
		this.flag = flag;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	
	
}
