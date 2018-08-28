package com.javalec.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dao.DiscountDao;
import com.javalec.ex.dto.BDto;
import com.javalec.ex.dto.Discount;

public class BContentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String bId = request.getParameter("bId");
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId);
		DiscountDao disDao = new DiscountDao();
		ArrayList<Discount> disDto = disDao.list(Integer.parseInt(bId));
		request.setAttribute("content_view", dto);
		request.setAttribute("discount", disDto);
	}

}
