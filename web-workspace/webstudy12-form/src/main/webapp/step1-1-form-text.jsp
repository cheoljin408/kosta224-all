<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp와 html form 연동 테스트</title>
</head>
<body>
	<form action="step1-2-form-action.jsp">
		<input type="text" name="userId" placeholder="아이디" required="required" />
		<input type="text" name="userName" placeholder="이름" required="required" />
		<input type="submit" value="전송" />
	</form>
</body>
</html>