package com.javalec.ex.mail;



import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendMail() {
        super();
    
    }



    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		Random random = new Random();
		int verfiyCode = random.nextInt(99999 - 10000 + 1) + 10000; // 인증코드 생성 후
		String email = request.getParameter("email"); // 회원 가입 메일 
		
		// 세션에 인증코드를 담음. 
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("code", verfiyCode);
		
		try {
			String mail_from = "kyonggi_used@kyonggi.ac.kr";
			String mail_to =  email;
			request.setAttribute("email", email);
			String Mailtitle = "[경기대 중고장터] 학교 인증 확인 메일";
			String contents = "<h1>This is your code : " + verfiyCode + "</h1>";
			
			mail_from = new String(mail_from.getBytes("UTF-8"),"UTF-8" );
			mail_to = new String(mail_to.getBytes("UTF-8"), "UTF-8");
			
			Properties properties = new Properties();
			properties.put("mail.transport.protocol", "smtp");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.socketFactory.fallback", "false");
			properties.put("mail.smtp.auth", "true");
			
			Authenticator authenticator = new SMTPAuthenticator();
			
			Session session = Session.getDefaultInstance(properties, authenticator);
			
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(mail_from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail_to));
			message.setSubject(Mailtitle, "UTF-8");
			message.setContent(contents, "text/html; charset=UTF-8");
			message.setHeader("Content-type", "text/html; charset=UTF-8");
			
			Transport.send(message);

			//인증코드 입력하는 창으로
			RequestDispatcher dispatcher = request.getRequestDispatcher("codeCheck.jsp");
			dispatcher.forward(request, response);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
