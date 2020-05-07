<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member member = (Member)request.getAttribute("member");
	String userId = member.getUserId();
	String userPw = member.getUserPwd();
	String userName = member.getUserName();
	String phone = member.getPhone() != null ? member.getPhone() : "";
	String email = member.getEmail() != null ? member.getEmail() : "";
	String addr = member.getAddr() != null ? member.getAddr() : "";
	String[] checkedInterest = new String[6];
	
	if(member.getInterest() != null){
		String[] interests = member.getInterest().split(",");
		for(int i = 0; i < interests.length; i++){
			switch(interests[i]){
			case "운동" : checkedInterest[0] = "checked"; break;
			case "등산" : checkedInterest[1] = "checked"; break;
			case "낚시" : checkedInterest[2] = "checked"; break;
			case "요리" : checkedInterest[3] = "checked"; break;
			case "게임" : checkedInterest[4] = "checked"; break;
			case "기타" : checkedInterest[5] = "checked"; break;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
   .outer{
      width:600px;
      height:500px;
      background:black;
      color:white;
      margin-left:auto;
      margin-right:auto;
      margin-top:50px;
   }
   
   .outer label, .outer td{
      color:white;
   }
   
   input{
      margin-top:2px;
   }
   
   #idCheck, #goMain, #updateBtn, #deleteBtn {
      background:orangered;
      border-radius:5px;
      width:80px;
      height:25px;
      text-align:center;
   }
   
   #idCheck:hover, #updateBtn:hover, #goMain:hover, #deleteBtn:hover {
      cursor:pointer;
   }
   td {
      text-align:right;
   }
   #updateBtn, #deleteBtn {
      background:yellowgreen;
   }
   #updateBtn, #goMain, #deleteBtn {
      display:inline-block;
   }
</style>
<title>마이페이지</title>
</head>
<body>
   <%@ include file="../common/menubar.jsp" %>
   
   <div class="outer">
      <br>
      <h2 align="center">회원 정보 수정</h2>
      <!-- memberJoinForm에 있는 table를 복사할 것! -->
      <!-- 각각의 input에 value값 추가 -->
      <form id="updateForm" action="<%=request.getContextPath()%>/update.me" method="post">
         <table>
            <tr>
               <td width="200px">* 아이디</td>
               <td><input type="text" maxlength="13" name="userId" value="<%= userId %>" readonly></td>
               <!-- <td width="200px"><div id="idCheck">중복확인</div></td> -->
            </tr>
            <!-- <tr>
               <td>* 비밀번호</td>
               <td><input type="password" maxlength="13" name="userPwd" required></td>
            </tr>
            <tr>
               <td>* 비밀번호 확인</td>
               <td><input type="password" maxlength="13" name="userPwd2" required></td>
               <td><label id="pwdResult"></label></td>
            </tr> -->
            <tr>
               <td>* 이름</td>
               <td><input type="text" maxlength="5" name="userName" required value="<%= userName %>"></td>
            </tr>
            <tr>
               <td>연락처</td>
               <td>
                  <input type="tel" maxlength="11" name="phone" placeholder="(-없이)01012345678" value="<%= phone %>">
               </td>
            </tr>
            <tr>
               <td>이메일</td>
               <td><input type="email" name="email" value="<%= email %>"></td>
            </tr>
            <tr>
               <td>주소</td>
               <td><input type="text" name="address" value="<%= addr %>"></td>
            </tr>
            <tr>
               <td>관심분야</td>
               <td>
                  <input type="checkbox" id="sports" name="interest" value="운동" <%= checkedInterest[0] %>>
                  <label for="sports">운동</label>
                  <input type="checkbox" id="climbing" name="interest" value="등산" <%= checkedInterest[1] %>>
                  <label for="climbing">등산</label>
                  <input type="checkbox" id="fishing" name="interest" value="낚시" <%= checkedInterest[2] %>>
                  <label for="fishing">낚시</label> <br>
                  <input type="checkbox" id="cooking" name="interest" value="요리" <%= checkedInterest[3] %>>
                  <label for="cooking">요리</label>
                  <input type="checkbox" id="game" name="interest" value="게임" <%= checkedInterest[4] %>>
                  <label for="game">게임</label>
                  <input type="checkbox" id="etc" name="interest" value="기타" <%= checkedInterest[5] %>>
                  <label for="etc">기타</label>
               </td>
            </tr>
         </table>
         <br>
         
         <div class="btns" align="center">
            <div id="goMain" onclick="goMain();">메인으로</div>
            <div id="updateBtn" onclick="updateMember();">수정하기</div>
            <div id="deleteBtn" onclick="deleteMember();">탈퇴하기</div>
         </div>
      </form>
      
      <!-- 잘 조회 되는지 확인!! -->
      <!-- 잘 조회 된다면 이제 부터 수정하기 작업하기!!! -->
      <script>
      	function goMain(){	
			location.href="<%=request.getContextPath()%>/index.jsp";
		}
      </script>
   </div>
	<button onclick="goHome();">메인으로 가기</button>
	<script>
		function goHome(){
			location.href="<%=request.getContextPath()%>/index.jsp";
		}
		function updateMember(){
			$("#updateForm").submit();
			//UpdateMemberServlet 만들기
		}
		function deleteMember(){
			$("#updateForm").attr("action", "<%=request.getContextPath()%>/delete.me");
			/* 
			하나의 폼태그로 두가지 속성 
			기존의 form 태그 경로는 회원 정보 수정을 위한 url mapping 주소이므로
			회원 탈퇴는 경로를 수정해주자.
			*/
			$("#updateForm").submit();
			/*deleteMemberServlet만들기*/
		}
	</script>
</body>
</html>









