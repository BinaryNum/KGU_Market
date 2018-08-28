package com.javalec.ex.mail;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Verify
 */
@WebServlet("/Verify")
public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Verify() {
        super();
    }

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		int inputCode = Integer.parseInt(request.getParameter("code"));
		HttpSession session = request.getSession();
		int currentUserVerifyCode = (Integer)session.getAttribute("code");
		RequestDispatcher dispatcher;
		request.setAttribute("email", email);
		
		if(inputCode == currentUserVerifyCode) {
			dispatcher = request.getRequestDispatcher("signup.jsp");
			
		}else {
			dispatcher = request.getRequestDispatcher("codeCheck.jsp");
		}
		dispatcher.forward(request, response);
	}

}
