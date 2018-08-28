package com.javalec.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.javalec.ex.command.Command;
import com.javalec.ex.command.DiscountAcceptCommand;
import com.javalec.ex.command.DiscountDeleteCommand;
import com.javalec.ex.command.DiscountRejectCommand;
import com.javalec.ex.command.DiscountWriteCommand;
import com.javalec.ex.command.BContentCommand;
import com.javalec.ex.command.BDeleteCommand;
import com.javalec.ex.command.InterestedCommand;
import com.javalec.ex.command.InterestedDeleteCommand;
import com.javalec.ex.command.IndexCommand;
import com.javalec.ex.command.LowerPriceCommand;
import com.javalec.ex.command.BListCommand;
import com.javalec.ex.command.BModifyCommand;
import com.javalec.ex.command.BReplyCommand;
import com.javalec.ex.command.BReplyViewCommand;
import com.javalec.ex.command.BSearchCommand;
import com.javalec.ex.command.BSoldCommand;
import com.javalec.ex.command.BWriteCommand;
import com.javalec.ex.command.CCommentDeleteCommand;
import com.javalec.ex.command.CCommentWriteCommand;
import com.javalec.ex.command.CContentCommand;
import com.javalec.ex.command.CDeleteCommand;
import com.javalec.ex.command.CListCommand;
import com.javalec.ex.command.CModifyCommand;
import com.javalec.ex.command.CReplyCommand;
import com.javalec.ex.command.CReplyViewCommand;
import com.javalec.ex.command.CWriteCommand;
import com.javalec.ex.command.NContentCommand;
import com.javalec.ex.command.NDeleteCommand;
import com.javalec.ex.command.MemberIdCheck;
import com.javalec.ex.command.MemberInsertCommand;
import com.javalec.ex.command.MemberLoginCommand;
import com.javalec.ex.command.MemberLogoutCommand;
import com.javalec.ex.command.MemberMypageCommand;
import com.javalec.ex.command.NListCommand;
import com.javalec.ex.command.NModifyCommand;
import com.javalec.ex.command.NWriteCommand;
import com.javalec.ex.mail.SendMail;
import com.javalec.ex.mail.Verify;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("actionDo");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		Command command = null;
		
		//HttpSession session=request.getSession();//
	//	session.setAttribute("userid", "admin");//
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		//중고 게시판 관리
		if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
		} else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}else if(com.equals("/index.do")) {
			command = new IndexCommand();
			command.execute(request, response);
			viewPage = "index.jsp";
		} else if(com.equals("/content_view.do")){
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		}else if(com.equals("/content_modify.do")){
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_modify.jsp";
		} else if(com.equals("/modify.do")) {
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/delete.do")) {
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/reply_view.do")) {
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		} else if(com.equals("/reply.do")) {
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/interested.do")) {
			command = new InterestedCommand();
			command.execute(request, response);
			viewPage = "mypage.do";
		}else if(com.equals("/interested_delete.do")) {
			command = new InterestedDeleteCommand();
			command.execute(request, response);
			viewPage = "mypage.do";
		}else if(com.equals("/discount_write.do")) {
			command = new DiscountWriteCommand();
			command.execute(request, response);
			viewPage = "content_view.do";
		}else if(com.equals("/discount_delete.do")) {
			command = new DiscountDeleteCommand();
			command.execute(request, response);
			viewPage = "content_view.do";
		}else if(com.equals("/discount_accept.do")) {
			command = new DiscountAcceptCommand();
			command.execute(request, response);
			viewPage = "content_view.do";
		}else if(com.equals("/discount_reject.do")) {
			command = new DiscountRejectCommand();
			command.execute(request, response);
			viewPage = "content_view.do";
		}
		//커뮤니티관리
		else if(com.equals("/community_write_view.do")) {
			viewPage = "community_write_view.jsp";
		} else if(com.equals("/community_write.do")) {
			command = new CWriteCommand();
			command.execute(request, response);
			viewPage = "community_list.do";
		} else if(com.equals("/community_list.do")) {
			command = new CListCommand();
			command.execute(request, response);
			viewPage = "community_list.jsp";
		} else if(com.equals("/community_content_view.do")){
			command = new CContentCommand();
			command.execute(request, response);
			viewPage = "community_content_view.jsp";
		}else if(com.equals("/community_content_modify.do")){
			command = new CContentCommand();
			command.execute(request, response);
			viewPage = "community_content_modify.jsp";
		} else if(com.equals("/community_modify.do")) {
			command = new CModifyCommand();
			command.execute(request, response);
			viewPage = "community_list.do";
		} else if(com.equals("/community_delete.do")) {
			command = new CDeleteCommand();
			command.execute(request, response);
			viewPage = "community_list.do";
		} else if(com.equals("/community_reply_view.do")) {
			command = new CReplyViewCommand();
			command.execute(request, response);
			viewPage = "community_reply_view.jsp";
		} else if(com.equals("/community_reply.do")) {
			command = new CReplyCommand();
			command.execute(request, response);
			viewPage = "community_list.do";
		} 
		//커뮤니티 댓글 관련
		else if(com.equals("/community_comment_write.do")) {
			command = new CCommentWriteCommand();
			command.execute(request, response);
			viewPage =  "community_content_view.do?bId="+request.getParameter("bId");
		}else if(com.equals("/community_comment_delete.do")) {
			command = new CCommentDeleteCommand();
			command.execute(request, response);
			viewPage = "community_content_view.do?bId="+request.getParameter("bId");
		} 
		
		
		//회원관리
		else if(com.equals("/signup.do")) {
			command = new MemberInsertCommand();
			command.execute(request, response);
			viewPage = "index.do";
		}
		else if(com.equals("/doublecheck.do")) {
			command=new MemberIdCheck();
			command.execute(request, response);
		}
		else if(com.equals("/Logincheck.do")) {
			command=new MemberLoginCommand();
			command.execute(request, response);
		}else if(com.equals("/logout.do")) {
			command=new MemberLogoutCommand();
			command.execute(request, response);
			viewPage = "index.do";
		}else if(com.equals("/mypage.do")) {
			command=new MemberMypageCommand();
			command.execute(request, response);
			viewPage = "mypage.jsp";
		}else if(com.equals("/send.do")) {
			SendMail send = new SendMail();
			send.execute(request, response);
		}else if(com.equals("/verify.do")) {
			Verify verify = new Verify();
			verify.execute(request, response);
		}
		
		//공지게시판 관리용
		else if(com.equals("/notice.do")) {
			command = new NListCommand();
			command.execute(request, response);
			viewPage = "notice.jsp";
		}if(com.equals("/Nwrite_view.do")) {
			viewPage = "Nwrite_view.jsp";
		}else if(com.equals("/Ncontent_modify.do")){
			command = new NContentCommand();
			command.execute(request, response);
			viewPage = "Ncontent_modify.jsp";
		}else if(com.equals("/Nmodify.do")) {
			command = new NModifyCommand();
			command.execute(request, response);
			viewPage = "notice.do";
		}else if(com.equals("/Nwrite.do")) {
			command = new NWriteCommand();
			command.execute(request, response);
			viewPage = "notice.do";
		}else if(com.equals("/Ndelete.do")) {
			command = new NDeleteCommand();
			command.execute(request, response);
			viewPage = "notice.do";
		}else if(com.equals("/Ncontent_view.do")){
			command = new NContentCommand();
			command.execute(request, response);
			viewPage = "Ncontent_view.jsp";
		}
		
		//기타 기능
		else if(com.equals("/search.do")){
			command = new BSearchCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}else if(com.equals("/sold.do")){
			command = new BSoldCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/lower_price.do")){
			command = new LowerPriceCommand();
			command.execute(request, response);
			viewPage = "lower_price_list.do";
		}else if(com.equals("/lower_price_list.do")) {
			command = new LowerPriceCommand();
			command.execute(request, response);
			viewPage = "lower_price_list.jsp";
		}
		if(viewPage==null) {
			return;
		}
		System.out.println(viewPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
