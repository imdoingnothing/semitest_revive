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
import member.model.vo.Member;

/**
 * Servlet implementation class updateMemberServlet
 */
@WebServlet("/update.me")
public class updateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		한글셋팅
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] irr = request.getParameterValues("interest");
		
		String interest = "";
//		한 컬럼값에 취미들을 넣기 위해서 ,를 기준으로 String[]을 하나의 String으로
//		전환(String의 join 메소드)
		if(irr != null) {
			interest = String.join(",", irr);
		}
//		업데이트하기
		int result = new MemberService().updateMember(new Member(userId, userName, phone, email, address, interest));
		
		RequestDispatcher view = null;
		if(result > 0) {
			HttpSession session = request.getSession();
			if(session != null) {
				session.invalidate();
			}
			view = request.getRequestDispatcher("views/common/successPage.jsp");
			request.setAttribute("msg", "회원 수정 완료");
		}
		else {
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "회원 수정 실패");
		}
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}














