<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>register-member</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container pt-4">
			<h3>회원가입</h3>
			<a href="index.jsp">Home</a>
			<form action="RegisterMemberController.do" method="post" onsubmit="return checkRegForm()">
				<input type="text" name="id" id=id required="required" placeholder="아이디" >
				<input type="hidden" id="flag" value="" >
				<button type="button" onclick="checkId()">중복확인</button>
				<br>
				<input type="text" name="password" id="password" required="required" placeholder="패스워드" >
				<br>
				<input type="text" name="confirmPassword" id="confirmPassword" required="required" placeholder="패스워드확인" >
				<br>
				<input type="text" name="name" required="required" placeholder="이름" >
				<br>
				<input type="text" name="address" required="required" placeholder="주소" >
				<br>
				<input type="date" name="birthday" required="required" placeholder="생년월일" >
				<br>
				<button type="submit" id="btn">회원가입</button>
			</form>
		</div>
		<script type="text/javascript">
	 		function checkRegForm() {
				let password = document.getElementById("password").value;
				console.log(password);
				let confirmPassword = document.getElementById("confirmPassword").value;
				console.log(confirmPassword);
				
				if(password != confirmPassword) {
					alert("패스워드와 패스워드확인이 일치하지 않습니다");
					return false;
				}
				
				if(document.getElementById("flag").value != document.getElementById("id").value) {
					alert("인증받은 아이디가 아닙니다\n아이디 중복 확인하세요");
					return false;
				}
			}
	 		
	 		function checkId() {
	 			let id = document.getElementById("id");
	 			if(id.value === "") {
	 				alert("아이디를 입력하세요");
	 				memberId.focus();
	 			}
	 			else {
	 	 			window.open("IdCheckController.do?id=" + id.value, "mypopup", "width=500, height=500, top=150, left=100");
	 			}
	 		}
		</script>
	</body>
</html>