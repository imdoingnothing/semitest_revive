package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.PageInfo;

@WebServlet("/list.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		두개의 서비스를 호출하기 떄문에 service를 참조변수로 놓자
		BoardService bService = new BoardService();
//		1_1 게시판 리스트 갯수 구하기
		int listCount = bService.getListCount();
//		페이징 처리 추가, 페이지처리용 변수 선언
		int currentPage;			//현재 페이지를 저장할 변수
		int limit;						//한 페이지에 보여질 게시글 수
		int maxPage;				//전체 페이지의 맨 마지막 페이지 (총 페이지 수)
		int startPage;				//한번에 표시될 페이지가 시작할 페이지
		int endPage;				//한번에 표시될 페이지가 끝나는 페이지
//		기본 게시판 페이지는 1페이지부터 시작
		currentPage = 1;
//		페이지 전환시 전달받은 현재 페이지가 있을 시 해당 페이지를 currentPage로 적용
		if(request.getParameter("currentPage") != null) {		//!request.getParameter("currentPage").equals(null)
			currentPage = Integer.valueOf(request.getParameter("currentPage"));
		}
		limit = 10;
		maxPage = (int)((double)listCount/limit + 0.9);
//		아래쪽에 페이지수가 10개씩 보여지게 할 경우1, 11, 21,...
		startPage = ((int)((double)(currentPage/limit + 0.9) -1) * limit + 1);
		endPage = startPage + limit - 1;
		
//		ex)총 23페이지일 경우 20~30은 아니니까 설정을 따로 해줘야한다.
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(listCount, currentPage, limit, maxPage, startPage, endPage);
//		게시판에 뿌려줄 리스트 조회
		ArrayList<Board> list = bService.selectList(currentPage, limit);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}



















