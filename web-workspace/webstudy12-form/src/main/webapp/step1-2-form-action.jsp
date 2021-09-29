<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step1-2-form-action</title>
</head>
<body>
	<%-- form에서 전달한 아이디와 이름을 입력받아 화면에 제공한다 --%>
	고객아이디: <%=request.getParameter("userId") %>
	고객이름: <%=request.getParameter("userName") %>
</body>
</html>