/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2020-05-07 01:36:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/common/menubar.jsp", Long.valueOf(1588812568220L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 지시자태그 -->\r\n");
      out.write("\t");
      out.write('\r');
      out.write('\n');

  	/* session 객체의 반환 타입은 Object다 */
	Member loginUser = (Member)session.getAttribute("loginUser");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script  src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction validate(){\r\n");
      out.write("\t\t/* 로그인시 아이디를 입력하지 않았다면 */\r\n");
      out.write("\t\tif($(\"#userId\").val().trim().length == 0){\r\n");
      out.write("\t\t\talert(\"아이디를 입력하지 않았습니다.\");\r\n");
      out.write("\t\t\t$(\"#userId\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif($(\"#userPwd\").val().trim().length == 0){\r\n");
      out.write("\t\t\talert(\"비밀번호를 입력하지 않았습니다.\");\r\n");
      out.write("\t\t\t$(\"#userPwd\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("\tbody{\r\n");
      out.write("\t\tbackground : url('");
      out.print(request.getContextPath());
      out.write("/image/city1.PNG') no-repeat ;\r\n");
      out.write("\t}\r\n");
      out.write("\t#loginBtn input, #memberJoinBtn, #logoutBtn, #myPage{\r\n");
      out.write("\t\tdisplay : inline-block;\r\n");
      out.write("\t\tvertical-align : middel;\r\n");
      out.write("\t\ttext-align : center;\r\n");
      out.write("\t\tbackground : orangered;\r\n");
      out.write("\t\tcolor : white;\r\n");
      out.write("\t\theight : 25px;\r\n");
      out.write("\t\twidth : 100px;\r\n");
      out.write("\t\tborder-radius : 5px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#memberJoinBtn{\r\n");
      out.write("\t\tbackground : yellowgreen;\r\n");
      out.write("\t}\r\n");
      out.write("\t#loginBtn:hover, #changeInfo:hover, #logoutBtn:hover,\r\n");
      out.write("\t#memberJoinBtn:hover, #myPage:hover{\r\n");
      out.write("\t\tcursor : pointer;\r\n");
      out.write("\t}\r\n");
      out.write("\t.loginArea > form, #userInfo{\r\n");
      out.write("\t\tfloat : right;\r\n");
      out.write("\t}\r\n");
      out.write("\t#logout, #myPage{\r\n");
      out.write("\t\tbackground : orangered;\r\n");
      out.write("\t\tcolor : white;\r\n");
      out.write("\t\ttext-decoration : none;\r\n");
      out.write("\t\tborder-radius : 5px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#myPage {\r\n");
      out.write("      background:yellowgreen;\r\n");
      out.write("   \t}\r\n");
      out.write("   \r\n");
      out.write("   \t.wrap {\r\n");
      out.write("      background:black;\r\n");
      out.write("      width:100%;\r\n");
      out.write("      height:50px;\r\n");
      out.write("   \t}\r\n");
      out.write("   \t.menu {\r\n");
      out.write("      background:black;\r\n");
      out.write("      color:white;\r\n");
      out.write("      text-align:center;\r\n");
      out.write("      vertical-align:middle;\r\n");
      out.write("      width:150px;\r\n");
      out.write("      height:50px;\r\n");
      out.write("      display:table-cell;\r\n");
      out.write("   \t}\r\n");
      out.write("   \t.nav {\r\n");
      out.write("      width:600px;\r\n");
      out.write("      margin-left:auto;\r\n");
      out.write("      margin-right:auto;\r\n");
      out.write("   \t}\r\n");
      out.write("   \t.menu:hover {\r\n");
      out.write("      background:darkgray;\r\n");
      out.write("      color:orangered;\r\n");
      out.write("      font-weight:bold;\r\n");
      out.write("      cursor:pointer;\r\n");
      out.write("   \t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1 align=\"center\">Welcome JSP World!</h1>\r\n");
      out.write("\t<!-- 로그인 관련 폼 -->\r\n");
      out.write("\t<!-- 로그인이 되었는지 확인 -->\r\n");
      out.write("\t<div class=\"loginArea\">\r\n");
      out.write("\t");
if(loginUser == null){ 
      out.write("\r\n");
      out.write("\t\t<!-- request.getContextPath() > context의 경로대로 실행 -->\r\n");
      out.write("\t\t<form method=\"get\" action=\"");
      out.print(request.getContextPath());
      out.write("/login.me\" onsubmit=\"return validate();\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><label>ID : </label></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"userId\" id=\"userId\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><label>PW : </label></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" name=\"userPwd\" id=\"userPwd\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\"><input type=\"checkbox\" name=\"saveId\" id=\"saveId\"></td>\r\n");
      out.write("\t\t\t\t\t<td><label for=\"saveId\">아이디 저장</label></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<div class=\"btns\" align=\"center\">\r\n");
      out.write("\t\t\t\t<div id=\"memberJoinBtn\" onclick=\"memberJoin();\">회원가입</div>\r\n");
      out.write("\t\t\t\t<div id=\"loginBtn\"><input type=\"submit\" value=\"로그인\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\t\r\n");
      out.write("\t");
} else{
      out.write("\r\n");
      out.write("\t\t<div id=\"userInfo\">\r\n");
      out.write("\t\t\t<label>");
      out.print( loginUser.getUserName());
      out.write("님 환영합니다.</label>\r\n");
      out.write("\t\t\t<div class=\"btns\" align=\"right\">\r\n");
      out.write("\t\t\t\t<div id=\"myPage\" onclick=\"location.href='/webs/myPage.me?userId=");
      out.print(loginUser.getUserId());
      out.write("'\">정보수정</div>\r\n");
      out.write("\t\t\t\t<div id=\"logoutBtn\" onclick=\"logout();\">로그아웃</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br clear=\"both\">\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction logout(){\r\n");
      out.write("\t\t\tlocation.href='");
      out.print(request.getContextPath());
      out.write("/logout.me';\r\n");
      out.write("\t\t\t// location.href는 해당 경로로 이동하기 위한 속성\r\n");
      out.write("\t\t\t// form태그가 아닌 단순히 넘어가길 원하는 Servlet으로 넘어가기 위해 사용\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction memberJoin(){\r\n");
      out.write("\t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/views/member/memberJoinForm.jsp\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<br clear=\"both\">\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div class=\"wrap\">\r\n");
      out.write("\t\t<div class=\"nav\">\r\n");
      out.write("\t\t\t<div class=\"menu\" onclick=\"goHome();\">HOME</div>\r\n");
      out.write("\t\t\t<div class=\"menu\" onclick=\"goNotice();\">공지사항</div>\r\n");
      out.write("\t\t\t<div class=\"menu\" onclick=\"goBoard();\">게시판</div>\r\n");
      out.write("\t\t\t<div class=\"menu\" onclick=\"goThumbnail();\">사진게시판</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction goHome(){\r\n");
      out.write("\t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction goNotice(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction goBoard(){\r\n");
      out.write("\t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/list.bo\";\r\n");
      out.write("\t\t\t//boardListServlet 생성\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction goThumbnail(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \t<h1>하윙</h1>\r\n");
      out.write("\t<table border=\"1\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>이름</th>\r\n");
      out.write("\t\t\t<th>나이</th>\r\n");
      out.write("\t\t\t<th>주소</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>고범석</td>\r\n");
      out.write("\t\t\t<td>26</td>\r\n");
      out.write("\t\t\t<td>서울 광진구 중곡동</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table> -->\r\n");
      out.write("\t<!-- 제일 먼저 세팅할 것들<br>\r\n");
      out.write("\t1. Window - Preferences<br>\r\n");
      out.write("\t\t1) 인코딩 관련한 것들 UTF-8로 바꿔주기<br>\r\n");
      out.write("\t\t2) Server 만들기<br>\r\n");
      out.write("\t2. Dynamic Web Project 생성<br>\r\n");
      out.write("\t\t1) Context root명은 간단하게 해주고\t<br>\r\n");
      out.write("\t\t2) web으로 바꿔주기<br>\r\n");
      out.write("\t\t3) 아래에 web.xml파일 만들기 꼭 체크하기<br>\r\n");
      out.write("\t\t4) 프로젝트명/web/web_INF/classes 폴더 추가<br>\r\n");
      out.write("\t3. Servers 탭에서 톰캣 세팅<br>\r\n");
      out.write("\t\t1) 마우스 우클릭 > new > Server<br>\r\n");
      out.write("\t4. Project 입장에서 톰캣 연동 체크하기<br>\r\n");
      out.write("\t\t1) 프로젝트명 우클릭 > Properties > Project facets > runtimes > 본인의 구동시킬 톰캣으로<br>\r\n");
      out.write("\t\t등록 되엇는지 확인<br>\r\n");
      out.write("\t5. 톰캣을 세팅하고 생성된 Servers폴더 안에 있는 context.xml을 복사<br>\r\n");
      out.write("\t\t> web-inf 폴더를 찾아 그 하위 폴더로 jspwork 폴더를 만들어두자.<br>\r\n");
      out.write("\t\t> Project의 Meta-inf아래에 붙여넣기 <br>\r\n");
      out.write("\t\t> 붙여넣은 context.xml안에 있는 context 태그의 workDir 속성에<br>\r\n");
      out.write("\t\t> 경로를 써넣자(WEB-INF 아래의 jspwork폴더 경로)<br>\r\n");
      out.write("-->\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
