package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.javalec.ex.dao.MemberDao;

public class MemberIdCheck implements Command{

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 String id=request.getParameter("id");
		 //System.out.println("============id========"+id);
		 MemberDao dao=new MemberDao();
		 int flag;
		try {
			flag = dao.selectOne(id);
		
		 System.out.println(flag);
		 JSONObject obj=new JSONObject();
		obj.put("idflag", flag);
		response.setContentType("application/x-json charset=UTF-8");
		response.getWriter().print(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
