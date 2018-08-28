package com.javalec.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.CCDao;
import com.javalec.ex.dao.CDao;
import com.javalec.ex.dto.CCDto;
import com.javalec.ex.dto.CDto;



public class CContentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String bId = request.getParameter("bId");
		CDao dao = new CDao();
		CDto dto = dao.contentView(bId);
		CCDao cdao = new CCDao();
		ArrayList<CCDto> cdtos = cdao.list(Integer.parseInt(bId));
		request.setAttribute("comments", cdtos);
		request.setAttribute("content_view", dto);
		
		
	}

}
