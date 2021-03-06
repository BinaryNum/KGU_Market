package com.javalec.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dto.BDto;

public class BSearchCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		request.setAttribute("search", search);
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.search(search);
		request.setAttribute("list", dtos);
	}
}