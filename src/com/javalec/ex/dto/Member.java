package com.javalec.ex.dto;



public class Member {
	
	protected String 	name;
	protected String 	email;
	protected String 	password;
	protected String 	interested;
	protected String 	phonenumber;
	protected String 	id;
	protected String 	gender;
	public String getName() {
		return name;
	}
	public Member setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Member setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Member setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getInterested() {
		return interested;
	}
	public Member setInterested(String interested) {
		this.interested = interested;
		return this;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public Member setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
		return this;
	}
	public String getId() {
		return id;
	}
	public Member setId(String id) {
		this.id = id;
		return this;
	}
	public String getGender() {
		return gender;
	}
	public Member setGender(String gender) {
		this.gender = gender;
		return this;
	}
	
	
	
}
