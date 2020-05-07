<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"
%>
<%
  	/* session 객체의 반환 타입은 Object다 */
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function validate(){
		/* 로그인시 아이디를 입력하지 않았다면 */
		if($("#userId").val().trim().length == 0){
			alert("아이디를 입력하지 않았습니다.");
			$("#userId").focus();
			return false;
		}
		if($("#userPwd").val().trim().length == 0){
			alert("비밀번호를 입력하지 않았습니다.");
			$("#userPwd").focus();
			return false;
		}
	}
</script>
<style>
	body{
		background : url('<%=request.getContextPath()%>/image/city1.PNG') no-repeat ;
		background-size : cover;
	}
	#loginBtn input, #memberJoinBtn, #logoutBtn, #myPage{
		display : inline-block;
		vertical-align : middel;
		text-align : center;
		background : orangered;
		color : white;
		height : 25px;
		width : 100px;
		border-radius : 5px;
	}
	#memberJoinBtn{
		background : yellowgreen;
	}
	#loginBtn:hover, #changeInfo:hover, #logoutBtn:hover,
	#memberJoinBtn:hover, #myPage:hover{
		cursor : pointer;
	}
	.loginArea > form, #userInfo{
		float : right;
	}
	#logout, #myPage{
		background : orangered;
		color : white;
		text-decoration : none;
		border-radius : 5px;
	}
	#myPage {
      background:yellowgreen;
   	}
   
   	.wrap {
      background:black;
      width:100%;
      height:50px;
   	}
   	.menu {
      background:black;
      color:white;
      text-align:center;
      vertical-align:middle;
      width:150px;
      height:50px;
      display:table-cell;
   	}
   	.nav {
      width:600px;
      margin-left:auto;
      margin-right:auto;
   	}
   	.menu:hover {
      background:darkgray;
      color:orangered;
      font-weight:bold;
      cursor:pointer;
   	}
</style>
</head>
<body>
	<h1 align="center">Welcome JSP World!</h1>
	<!-- 로그인 관련 폼 -->
	<!-- 로그인이 되었는지 확인 -->
	<div class="loginArea">
	<%if(loginUser == null){ %>
		<!-- request.getContextPath() > context의 경로대로 실행 -->
		<form method="get" action="<%=request.getContextPath()%>/login.me" onsubmit="return validate();">
			<table>
				<tr>
					<td><label>ID : </label></td>
					<td><input type="text" name="userId" id="userId"></td>
				</tr>
				<tr>
					<td><label>PW : </label></td>
					<td><input type="password" name="userPwd" id="userPwd"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="checkbox" name="saveId" id="saveId"></td>
					<td><label for="saveId">아이디 저장</label></td>
				</tr>
			</table>
			<div class="btns" align="center">
				<div id="memberJoinBtn" onclick="memberJoin();">회원가입</div>
				<div id="loginBtn"><input type="submit" value="로그인"></div>
			</div>
		</form>	
	<%} else{%>
		<div id="userInfo">
			<label><%= loginUser.getUserName()%>님 환영합니다.</label>
			<div class="btns" align="right">
				<div id="myPage" onclick="location.href='/webs/myPage.me?userId=<%=loginUser.getUserId()%>'">정보수정</div>
				<div id="logoutBtn" onclick="logout();">로그아웃</div>
			</div>
		</div>
	<%} %>
	</div>
	<br clear="both">
	<script>
		function logout(){
			location.href='<%=request.getContextPath()%>/logout.me';
			// location.href는 해당 경로로 이동하기 위한 속성
			// form태그가 아닌 단순히 넘어가길 원하는 Servlet으로 넘어가기 위해 사용
		}
		function memberJoin(){
			location.href="<%=request.getContextPath()%>/views/member/memberJoinForm.jsp";
		}
	</script>
	<br clear="both">
	<br>
	<div class="wrap">
		<div class="nav">
			<div class="menu" onclick="goHome();">HOME</div>
			<div class="menu" onclick="goNotice();">공지사항</div>
			<div class="menu" onclick="goBoard();">게시판</div>
			<div class="menu" onclick="goThumbnail();">사진게시판</div>
		</div>
	</div>
	<script>
		function goHome(){
			location.href="<%=request.getContextPath()%>/index.jsp";
		}
		function goNotice(){
			
		}
		function goBoard(){
			location.href="<%=request.getContextPath()%>/list.bo";
			//boardListServlet 생성
		}
		function goThumbnail(){
			
		}
	</script>
</body>
</html>


































