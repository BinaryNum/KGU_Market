package com.javalec.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.NDao;
import com.javalec.ex.dto.Ndto;

public class NListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		NDao dao = new NDao();
		ArrayList<Ndto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}
}