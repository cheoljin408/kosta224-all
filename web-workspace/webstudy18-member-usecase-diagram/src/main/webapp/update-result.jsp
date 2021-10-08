<%@page import="org.kosta.webstudy18.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update-result</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<div class="container">
		<h3>회원정보수정</h3>
		<a href="index.jsp">Home</a>
		<hr>
		회원정보수정완료<br><br>
		<%
		MemberVO vo = (MemberVO)session.getAttribute("mvo");
		%>
		아이디: <%=vo.getId() %><br>
		이름: <%=vo.getName() %><br>
		주소: <%=vo.getAddress() %><br>
	</div>
</body>
</html>