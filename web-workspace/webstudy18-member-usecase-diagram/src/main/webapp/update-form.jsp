<%@page import="org.kosta.webstudy18.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update-form</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<div class="container">
		<h3>회원정보수정</h3>
		<a href="index.jsp">Home</a>
		<hr>
		<%
		MemberVO vo = (MemberVO)session.getAttribute("mvo");
		if(vo != null) {
		%>
		<form action="UpdateMemberServlet" method="post">
			<p>아이디</p>
			<input type="text" name="memberId" readonly="readonly" value="<%=vo.getId() %>">
			<br>
			<p>패스워드</p>
			<input type="text" name="memberPass" required="required" value="<%=vo.getPassword() %>" >
			<br>
			<p>이름</p>
			<input type="text" name="memberName" required="required" value="<%=vo.getName() %>" >
			<br>
			<p>주소</p>
			<input type="text" name="memberAddress" required="required" value="<%=vo.getAddress() %>" >
			<br>
			<input type="submit" id="btn" value="수정하기">
		</form>
		<%
		}
		else {
			response.sendRedirect("index.jsp");
		}
		%>
	</div>
</body>
</html>