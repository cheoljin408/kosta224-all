<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvc-login</title>
</head>
<body>
	<%--
			db에 아이디 java와 패스워드 abcd가 존재한다고 가정
	
			mvc-login.jsp ------------- LoginServlet
											| 아이디와 패스워드가 일치하면 세션에 인증정보(회원객체)를 할당한다
											|
											| 재동작이 안되도록 redirect 이동시킨다
											|
											login-ok.jsp	or		login-fail.jsp
											아이유님 로그인				alert() 로그인 실패 후 mvc-login.jsp로 이동시킨다
	 --%>
	<form action="LoginServlet" method="post">
		<input type="text" name="memberId" placeholder="아이디" required="required"><br>
		<input type="password" name="memberPass" placeholder="패스워드" required="required"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>