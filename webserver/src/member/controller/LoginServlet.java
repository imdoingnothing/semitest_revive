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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * <request와 response>
		 * request : 서버에 요청하는 모든 정보들에 대한 보관
		 * response : 서비스를 요청하는 클라이언트와 ip나 url 보관
		 * > 쌍으로 서버를 왔다갔다 하면서 클라이언트에 정확한 정보를 제공
		 * 
		 * <post와 get방식의 차이>
		 * request와 response는 둘 다 head와 body로 나뉨
		 * post : body에 기록되서 전달(url에 보이지 않음)
		 * get : head에 기록되서 전달(url에 보임)
		 * 
		 * <객체를 담아 둘 수 있는 객체들 (scope가 좁은 순위)>
		 * 1.page
		 * 		자기 자신 페이지에서만 쓸 수 있다.(해당 jsp파일 안에서만 사용가능)
		 * 2.request
		 * 		전달 받은 대상의 jsp만 꺼낼 수 있다.(서비스 요청 및 응답시에만 가능)
		 * 3.session
		 * 		웹브라우저 유지 및 해당 시간동안 쓸 수 있다.
		 * 4.application
		 *		톰캣(was)이 유지되는 한 모든 곳에서 쓸 수 있다. 즉, jsp/servlet/java 모두에서 쓸 수 있다.
		 */
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member member = new Member(userId, userPwd);
		
		Member loginMember = new MemberService().loginMember(member);
//		System.out.println("Servlet에서 화면에 뿌려주기 전 : " + loginMember);
		
		if(loginMember != null) {
			HttpSession session = request.getSession(); 	//기본 30분 유지
			session.setAttribute("loginUser", loginMember);
//			우리가 원하는 시간만큼 session객체 유지
			session.setMaxInactiveInterval(10); //초단위
			response.sendRedirect("index.jsp");
		}
		else {
			request.setAttribute("msg", "로그인 실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
