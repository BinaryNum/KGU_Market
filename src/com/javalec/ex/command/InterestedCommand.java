package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dao.BasketDao;

import java.util.Enumeration;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

public class InterestedCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String userId = (String) session.getAttribute("userid");
		int bId = Integer.parseInt(request.getParameter("bId"));
		System.out.println("BID====="+bId);
		BasketDao dao = new BasketDao();
		dao.write(bId, userId);
		
			
	}
}
