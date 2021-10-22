<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>idcheck-fail</title>
	</head>
	<body>
		${param.id} 아이디 사용 가능합니다
		<br>
		<br>
		<button type="button" onclick="closePopup()">확인</button>
		<script type="text/javascript">
			// 현재 팝업을 띄운 본창의 hidden tag에 인증받은 아이디를 할당한다
			opener.document.getElementById("flag").value = "${param.id}";
			
			function closePopup() {
				console.log(opener);
				opener.document.getElementById("password").focus();
				self.close();
			}
		</script>
	</body>
</html>