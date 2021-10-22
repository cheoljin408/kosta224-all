<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>update-result</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container pt-4">
			<a href="index.jsp">Home</a>
			<h3>${sessionScope.mvo.name}님의 회원정보수정 결과</h3>
			<p>아이디: ${sessionScope.mvo.id}</p>
			<p>패스워드:${sessionScope.mvo.password}</p>
			<p>이름: ${sessionScope.mvo.name}</p>
			<p>주소: ${sessionScope.mvo.address}</p>
			<p>생년월일: ${sessionScope.mvo.birthday}</p>
		</div>
	</body>
</html>