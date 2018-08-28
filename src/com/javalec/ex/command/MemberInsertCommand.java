package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.MemberDao;

public class MemberInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String password=request.getParameter("pw1");
	String id=request.getParameter("id");
	String major=request.getParameter("interested");
	String phonenumber=request.getParameter("phonenumber");
	String gender=request.getParameter("gender");
	
	MemberDao dao=new MemberDao();
	try {
		dao.insert(name, password, email, id, major, phonenumber, gender);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
