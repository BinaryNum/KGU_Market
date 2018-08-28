package com.javalec.ex.dto;

public class Basket {
	int num;
	int bId;
	String userId;
	public Basket() {}
	public Basket(int num, int bId, String userId) {
		this.num=num;
		this.bId=bId;
		this.userId=userId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
