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
	<div class="container">
		<h3>Model2 MVC 회원관리</h3>
		<%-- 1. 아이디로 회원 검색 --%>
		<form action="FindMemberByIdServlet">
			<input type="text" name="memberId" required="required" placeholder="아이디" >
			<button type="submit">검색</button>
		</form>
		<br>
		<%
		MemberVO vo = (MemberVO)session.getAttribute("mvo");
		if(vo == null) {
		%>
		<form action="LoginServlet" method="post">
			<input type="text" name="memberId" required="required" placeholder="아이디" >
			<br>
			<input type="password" name="memberPass" required="required" placeholder="비밀번호" >
			<br>
			<button type="submit">로그인</button>
		</form>
		<br>
		<a href="register-form.jsp">회원가입</a>
		<%
		}
		else {
		%>
		<%=vo.getName() %>님 안녕하세요
		<%--
				a href 링크는 기본적으로 get 요청방식이다
				로그인, 로그아웃은 post 방식이 적합하다(get 방식은 사용자가 브라우저 url 상에서 주소를 기입해서 실행해도 동작이 되기 때문)
		--%>
		<script type="text/javascript">
			function logout() {
				document.getElementById("logoutForm").submit();
			}
		</script>
		<form action="LogoutServlet" method="post" id="logoutForm"></form>
		<a href="#" onclick="logout()">로그아웃</a>
		<a href="update-form.jsp">회원정보수정</a>
		<br>
		<br>
		<form action="FindMemberListByAddressServlet">
			<input type="text" name="memberAddress" required="required" placeholder="주소" >
			<button type="submit">검색</button>
		</form>
		<%
		}
		%>
	</div>
</body>
</html>