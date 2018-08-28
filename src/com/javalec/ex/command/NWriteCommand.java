package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.NDao;

import java.util.Enumeration;


public class NWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub


					String bTitle = request.getParameter("bTitle");
					String bContent = request.getParameter("bContent");
					NDao dao = new NDao();
					dao.write( bTitle, bContent);
				
	}
}
