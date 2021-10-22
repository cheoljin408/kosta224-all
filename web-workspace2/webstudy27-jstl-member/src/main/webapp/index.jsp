<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container pt-4">
			<h3>회원관리 프로그램</h3>
			<form action="FindMemberByIdController.do">
				<input type="text" name="memberId" required="required" placeholder="아이디" >
				<button type="submit">검색</button>
			</form>
			<c:choose>
				<%-- session mvo가 null 일때 로그인 폼을 보여준다 --%>
				<c:when test="${sessionScope.mvo == null}">
					<form action="LoginController.do" method="post">
						<input type="text" name="id" placeholder="아이디" required="required"><br>
						<input type="password" name="password" placeholder="패스워드" required="required"><br>
						<button type="submit">로그인</button>
					</form>
					<br>
					<br>
					<a href="register-member.jsp">회원가입</a>
				</c:when>
				<c:otherwise>
					${sessionScope.mvo.name} 님 로그인 상태<br><br>
					<a href="LogoutController.do">로그아웃</a>
					<form action="FindMemberListByAddressController.do">
						<input type="text" name="address" placeholder="주소" required="required">
						<button type="submit">검색</button>
					</form>
					<br>
					<a href="update-member.jsp">회원정보수정</a>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>