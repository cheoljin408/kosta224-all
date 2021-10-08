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
		<h3>회원가입</h3>
		<a href="index.jsp">Home</a>
		<hr>
		<%-- 가입하기 submit을 누르면 패스워드와 패스워드 확인란에 동일한 패스워트를 입력했을때만 submit 되게 javascript로 구현해본다 --%>
		<form action="RegisterMemberServlet" method="post" onsubmit="return checkRegForm()">
			<p>아이디</p>
			<input type="text" name="memberId" required="required" placeholder="아이디" >
			<input type="button" value="중복확인" onclick="openPopUp()">
			<br>
			<p>패스워드</p>
			<input type="text" name="memberPass" id="pass" required="required" placeholder="패스워드" >
			<br>
			<p>패스워드확인</p>
			<input type="text" name="confirmMemberPass" id="confirmPass" required="required" placeholder="패스워드확인" >
			<br>
			<p>이름</p>
			<input type="text" name="memberName" required="required" placeholder="이름" >
			<br>
			<p>주소</p>
			<input type="text" name="memberAddress" required="required" placeholder="주소" >
			<br>
			<button type="submit" id="btn">회원가입</button>
		</form>
	</div>
	<script type="text/javascript">
 		function checkRegForm() {
 			console.log("asdf");
			let pass = document.getElementById("pass").value;
			console.log(pass);
			let confirmPass = document.getElementById("confirmPass").value;
			console.log(confirmPass);
			
			if(pass === confirmPass) {
				alert("같습니다");
				return true;
			}
			else {
				alert("패스워드와 패스워드확인이 일치하지 않습니다");
				return false;
			}
		}
 		
 		function openPopUp() {
 			// 함수 동작 테스트 
 			//alert("팝업 테스트");
 			
 			//window.open("[팝업을 띄울 파일명 path]", "[별칭]", "[팝업 옵션]")
 			 window.open("idcheck-ok.jsp", "successPopUp", "width=450, height=250, top=150, left=200");
 		}
	</script>
</body>
</html>