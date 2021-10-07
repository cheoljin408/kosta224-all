<%@page import="org.kosta.webstudy18.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<%
	MemberVO vo = (MemberVO)session.getAttribute("mvo");
	%>
	<div class="container">
		<h3>Model2 MVC 회원관리</h3>
		<%-- 1. 아이디로 회원 검색 --%>
		<form action="FindMemberByIdServlet">
			<input type="text" name="memberId" required="required" placeholder="아이디" >
			<button type="submit">검색</button>
		</form>
		<br>
		<%
		if(vo == null) {
		%>
		<form action="LoginServlet" method="post">
			<input type="text" name="memberId" required="required" placeholder="아이디" >
			<br>
			<input type="password" name="memberPass" required="required" placeholder="비밀번호" >
			<br>
			<button type="submit">로그인</button>
		</form>
		<%
		}
		else {
		%>
		<form>
			<input type="text" name="memberAddress" required="required" placeholder="주소" >
			<button type="submit">검색</button>
		</form>
		<br>
		<%=vo.getName() %>님 안녕하세요
		<br>
		<br>
		<a href="LogoutServlet">로그아웃</a>
		<%
		}
		%>
		<br>
		<br>
		<a href="">회원가입</a>
	</div>
</body>
</html>