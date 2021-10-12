<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복</title>
</head>
<body bgcolor="orange" onunload="closePopup()">
	<%=request.getParameter("memberId") %>아이디 중복되어 사용 불가합니다
	<br>
	<br>
	<button onclick="closePopup()">확인</button>
	
	<script type="text/javascript">
		opener.document.getElementById("flag").value = "";
		
		function closePopup() {
			// 본창의 아이디 text란에 입력한 아이디 value를 삭제하고 포커스를 준다
			let memberId = opener.document.getElementById("memberId");
			memberId.value = "";
			memberId.focus();
			self.close();
		}
	</script>
</body>
</html>