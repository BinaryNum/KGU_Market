package com.javalec.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dto.BDto;

public class IndexCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BDao dao = new BDao();
		
		ArrayList<BDto> dtos = dao.list();
		ArrayList<BDto> ranking = dao.ranking();
		request.setAttribute("list", dtos);
		request.setAttribute("ranking", ranking);
	}
}