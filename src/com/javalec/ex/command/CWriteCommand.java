package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.CDao;

import java.util.Enumeration;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

public class CWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		
		
					HttpSession session=request.getSession();//
					System.out.println("session==="+session.getAttribute("userid"));
					
					String bName = (String)session.getAttribute("userid");
					String bTitle = request.getParameter("bTitle");
					String bContent = request.getParameter("bContent");
					
					
					CDao dao = new CDao();
					dao.write(bName, bTitle, bContent);
				
	}
}
