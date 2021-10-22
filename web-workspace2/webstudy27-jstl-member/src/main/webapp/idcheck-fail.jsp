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
		${param.id} 아이디 중복되어 사용 불가합니다
		<br>
		<br>
		<button onclick="closePopup()">확인</button>
		
		<script type="text/javascript">
			opener.document.getElementById("flag").value = "";
			
			function closePopup() {
				// 본창의 아이디 text란에 입력한 아이디 value를 삭제하고 포커스를 준다
				let id = opener.document.getElementById("id");
				id.value = "";
				id.focus();
				self.close();
			}
		</script>
	</body>
</html>