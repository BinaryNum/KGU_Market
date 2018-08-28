package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.BDao;

import java.util.Enumeration;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

public class BWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		//파일업로드
				String path = request.getRealPath("img");
				int size = 1024 * 1024 * 10; //10M
				String file = "";
				String oriFile = "";
				try{
					MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
					
					Enumeration files = multi.getFileNames();
					String str = (String)files.nextElement();
					HttpSession session=request.getSession();//
					System.out.println("session==="+session.getAttribute("userid"));
					
					file = multi.getFilesystemName(str);
					
					oriFile = multi.getOriginalFileName(str);
					String bName = (String)session.getAttribute("userid");
					String bTitle = multi.getParameter("bTitle");
					String bContent = multi.getParameter("bContent");
					int price = Integer.parseInt(multi.getParameter("price"));
					
					BDao dao = new BDao();
					dao.write(bName, bTitle, bContent, file, price);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
}
