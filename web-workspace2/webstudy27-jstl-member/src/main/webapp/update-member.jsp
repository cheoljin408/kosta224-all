<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>update-member</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container pt-4">
			<h3>${sessionScope.mvo.name}님 회원정보수정</h3>
			<form action="UpdateMemberController.do" method="post">
				<input type="text" name="id" readonly="readonly" value="${sessionScope.mvo.id}">
				<br>
				<input type="text" name="password" required="required" value="${sessionScope.mvo.password}" >
				<br>
				<input type="text" name="name" required="required" value="${sessionScope.mvo.name}" >
				<br>
				<input type="text" name="address" required="required" value="${sessionScope.mvo.address}" >
				<br>
				<input type="date" name="birthday" required="required" value="${sessionScope.mvo.birthday}" >
				<br>
				<button type="submit">수정</button>
			</form>
		</div>
	</body>
</html>