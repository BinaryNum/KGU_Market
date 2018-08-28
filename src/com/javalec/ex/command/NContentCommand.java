package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.NDao;
import com.javalec.ex.dto.Ndto;

public class NContentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String bId = request.getParameter("bId");
		NDao dao = new NDao();
		Ndto dto = dao.contentView(bId);
		
		request.setAttribute("content_view", dto);
		
	}

}
