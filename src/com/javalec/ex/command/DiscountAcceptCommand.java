package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.DiscountDao;




public class DiscountAcceptCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

					int cId = Integer.parseInt(request.getParameter("cId"));		
					System.out.println("cCID==========="+cId);
					DiscountDao dao = new DiscountDao();
					dao.reject(cId);			
	}
}
