package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.javalec.ex.dao.MemberDao;
import com.javalec.ex.dto.Member;

public class MemberLoginCommand implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		System.out.println(id);
		System.out.println(password);
		MemberDao dao=new MemberDao();
		Member vo = new Member();
		int flag =0;
		try {
			vo=dao.exist(id, password);
			
			if(vo != null) {
				flag = 1;
				HttpSession session=request.getSession();
				session.setAttribute("userid", id);
				String a=(String) session.getAttribute("userid");
				System.out.println("session="+a);
			}
			
			 JSONObject obj=new JSONObject();
			 obj.put("idcheck", flag);
			 response.setContentType("application/x-json charset=UTF-8");
			 response.getWriter().print(obj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
