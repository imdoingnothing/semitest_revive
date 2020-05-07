package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;

/**
 * Servlet implementation class deleteMemberServlet
 */
@WebServlet("/delete.me")
public class deleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int result = new MemberService().deleteMember(userId);
		RequestDispatcher view = null;
		
		if(result > 0) {
			HttpSession session = request.getSession();
			
			if(session != null) {
				session.invalidate();
			}
			view = request.getRequestDispatcher("views/common/successPage.jsp");
			request.setAttribute("msg", "회원 탈퇴 성공");
		} 
		else {
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "회원 탈퇴 실패");
		}
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
