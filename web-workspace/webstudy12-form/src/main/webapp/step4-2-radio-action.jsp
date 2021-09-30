<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step4-2-radio-action</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String menu = request.getParameter("menu");
	%>
	<%=menu %> 주문완료!
</body>
</html>