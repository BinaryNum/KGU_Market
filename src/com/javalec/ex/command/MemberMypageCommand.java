package com.javalec.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dao.BasketDao;
import com.javalec.ex.dto.BDto;

public class MemberMypageCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		String userId = (String) session.getAttribute("userid");
		BDao dao = new BDao();
		BasketDao basket = new BasketDao();
		ArrayList<BDto> dtos = dao.mylist(userId);
		ArrayList<Integer> basketVo = basket.list(userId);
		ArrayList<BDto> basketDtos = dao.basket(basketVo);
		request.setAttribute("mylist", dtos);
		request.setAttribute("basket", basketDtos);
		
	}
}