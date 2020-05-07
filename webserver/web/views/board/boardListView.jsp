<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, board.model.vo.*" %>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .outer{
      width:900px;
      height:500px;
      background:black;
      color:white;
      margin-left:auto;
      margin-right:auto;
      margin-top:50px;
   }
   table {
      border:1px solid white;
      text-align:center;
   }
   .tableArea {
      width:650px;
      height:350px;
      margin-left:auto;
      margin-right:auto;
   }
   .searchArea {
      width:650px;
      margin-left:auto;
      margin-right:auto;
   }
</style>
</head>
<body>
	<%@include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">게시판</h2>
		<div class="tableArea">
			<table align="center" id="listArea">
				<tr>
					<th width="100px">글번호</th>
					<th width="100px">카테고리</th>
					<th width="100px">글제목</th>
					<th width="100px">작성자</th>
					<th width="100px">조회수</th>
					<th width="100px">작성일</th>
				</tr>
				<% for(Board b: list){ %>
				<tr>
					<input type="hidden" value="<%=b.getbId() %>" />
					<td><%=b.getbId() %></td>
					<td><%=b.getCategory() %></td>
					<td><%=b.getbTitle() %></td>
					<td><%=b.getbWriter() %></td>
					<td><%=b.getbCount() %></td>
					<td><%=b.getCreateDate() %></td>
				</tr>
				<%} %>
			</table>
		</div>
		<!--페이징처리-->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 -->
			<button onclick="location.href='<%=request.getContextPath()%>/list.bo?currentPage=1'"> << </button>
			<!-- 이전 페이지로 -->
			<%if(currentPage == 1) {%>
				<button disabled> < </button>
			<%}else {%>
			<button onclick="location.href='<%=request.getContextPath()%>/list.bo?currentPage=<%=currentPage-1%>'"> < </button>
			<%} %>
			<!-- 10개의 페이지 목록 -->
			<%for(int p = startPage; p <= endPage; p++){ %>
				<%if(currentPage == p) {%>
					<button disabled><%=p %></button>
				<%} else {%>
					<button onclick="location.href='<%=request.getContextPath()%>/list.bo?currentPage=<%=p %>'"><%=p %></button>
				<%} %>
			<%}%>
			<!-- 다음 페이지로 -->
			<%if(currentPage == maxPage) {%>
				<button disabled> > </button>
			<%}else {%>
			<button onclick="location.href='<%=request.getContextPath()%>/list.bo?currentPage=<%=currentPage+1%>'"> > </button>
			<%} %>
			<!-- 맨 마지막으로 -->
			<button onclick="location.href='<%=request.getContextPath()%>/list.bo?currentPage=<%=maxPage%>'"> >> </button>
		</div>
	</div>
</body>
</html>










