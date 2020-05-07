package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/insert.me")
public class insertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.한글이 있을 경우 인코딩 처리
		request.setCharacterEncoding("UTF-8");

//		2.전송 값을 꺼내서 (request주머니 안에 있는 값들을 name값으로 뽑아내기)
//		변수에 저장 및 객체에 저장
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
//		체크박스는 배열로 넘어온다
		String[] interests = request.getParameterValues("interest");
		String interest = "";
		if(interests != null) {
			for(int i = 0; i < interests.length; i++) {
				if(i != interests.length - 1) {
					interest += interests[i] + ", ";
				}
				else {
					interest += interests[i];
				}
			}
		}
		
		Member member = new Member(userId, userPwd, userName, phone, email, address, interest);
		int result = new MemberService().insertMember(member);
		
		String page = "";
		if(result > 0) {
			page = "views/common/successPage.jsp";
//			System.out.println("회원가입 성공");
			request.setAttribute("msg", "회원가입 성공");
		}
		else {
//			System.out.println("회원가입 실패");			
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원가입 실패");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
