package com.javalec.ex.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator{
	public SMTPAuthenticator() {
		super();
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		String username="binarynum01@gmail.com";
		//String username="ehdrjsdlzzzz@gmail.com";
		//String password="ehdrjs)624";
		String password="wlstn2323";
		return new PasswordAuthentication(username, password);
	}
}
