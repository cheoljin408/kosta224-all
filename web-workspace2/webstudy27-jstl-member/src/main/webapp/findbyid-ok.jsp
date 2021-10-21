<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>findbyid-ok</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container pt-4"> <%-- pt: padding-top --%>
			<h3>회원검색 결과</h3>
			<a href="index.jsp">Home</a>
			<br>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>주소</th>
						<th>생년월일</th>
						<th>가입일시</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${memberVO.id}</td>
						<td>${memberVO.name}</td>
						<td>${memberVO.address}</td>
						<td>${memberVO.birthday}</td>
						<td>${memberVO.regdate}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
</html>