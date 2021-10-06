<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login-ok</title>
</head>
<body>
	<%--
			LoginServlet에서 할당한 session의 회원객체에서 name을 얻어와서 보여준다
	 --%>
	 <%
	 	MemberVO vo = (MemberVO)session.getAttribute("mvo");
	 %>
	<%=vo.getId() %>님 로그인 OK
</body>
</html>