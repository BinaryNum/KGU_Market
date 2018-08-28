package com.javalec.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.CDao;
import com.javalec.ex.dto.CDto;

public class CListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		CDao dao = new CDao();
		ArrayList<CDto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}
}