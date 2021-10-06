<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp session test</title>
</head>
<body>
	<%--
			web container에 의해 jsp가 java로 생성되어 실행 될 때 session을 생성하므로 아래와 같이
			세션 아이디를 확인할 수 있다(tomcat/work에서 확인)
	 --%>
	session id: <%=session.getId() %>
	<%--
			같은 원리로 ServletConfig와 ServletContext 객체도 config와 application 변수로 사용할 수 있다
	 --%>
	 <br>
	 <br>
	 ServletConfig: <%=config %>
	 <br>
	 <br>
	 ServletContext: <%=application %>
	 <br>
	 <br>
	 <%--
	 		session에 회원 객체를 할당해본다
	  --%>
	  <%
	  MemberVO vo = new MemberVO("javaking", null, "아이유", "오리");
	  session.setAttribute("mvo", vo);
	  %>
	  <a href="session-test2.jsp">session2에서 확인</a>
</body>
</html>