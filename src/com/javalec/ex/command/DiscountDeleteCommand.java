package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.DiscountDao;




public class DiscountDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

					String cId = request.getParameter("cId");			
					DiscountDao dao = new DiscountDao();
					dao.delete(cId);			
	}
}
