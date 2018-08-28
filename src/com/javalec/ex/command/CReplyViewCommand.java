package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.CDao;
import com.javalec.ex.dto.CDto;



public class CReplyViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bId = request.getParameter("bId");
		CDao dao = new CDao();
		CDto dto = dao.reply_view(bId);
		
		request.setAttribute("reply_view", dto);
		
	}

}
