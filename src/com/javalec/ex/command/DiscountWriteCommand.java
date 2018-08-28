package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.DiscountDao;




public class DiscountWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		
		
					HttpSession session=request.getSession();//
					System.out.println("session==="+session.getAttribute("userid"));
					String bName = request.getParameter("bName");
					String userId = (String)session.getAttribute("userid");
					int bId = Integer.parseInt(request.getParameter("bId"));
					String contents = request.getParameter("contents");
					
					
					DiscountDao dao = new DiscountDao();
					dao.write(bId, bName, userId, contents);
				
	}
}
