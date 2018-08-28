package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.DiscountDao;




public class DiscountRejectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

					int cId = Integer.parseInt(request.getParameter("cId"));			
					DiscountDao dao = new DiscountDao();
					dao.accept(cId);			
	}
}
