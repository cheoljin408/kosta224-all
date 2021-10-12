<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 사용 가능</title>
</head>
<body bgcolor="yellow" onunload="closePopup()">
	<%=request.getParameter("memberId") %> 아이디 사용 가능합니다
	<br>
	<br>
	<button type="button" onclick="closePopup()">확인</button>
	<script type="text/javascript">
		// 현재 팝업을 띄운 본창의 hidden tag에 인증받은 아이디를 할당한다
		opener.document.getElementById("flag").value = "<%=request.getParameter("memberId") %>";
		
		function closePopup() {
			console.log("asdf");
			console.log(opener);
			opener.document.getElementById("pass").focus();
			self.close();
		}
	</script>
</body>
</html>