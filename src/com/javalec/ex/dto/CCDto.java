package com.javalec.ex.dto;

import java.sql.Timestamp;

public class CCDto {

	int bId;
	int cId;
	String userId;
	String contents;
	
	public CCDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CCDto(int cId, int bId, String userId, String contents) {
		// TODO Auto-generated constructor stub
		this.bId = bId;
		this.cId = cId;
		this.userId = userId;
		this.contents = contents;
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
