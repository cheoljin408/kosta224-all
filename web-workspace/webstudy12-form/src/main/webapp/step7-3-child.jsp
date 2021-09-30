<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step7-3-child</title>
</head>
<body bgcolor="yellow">
	<%
	String name = request.getParameter("name");
	%>
	<%=name %>님 미성년자가 볼 수 있는 영화가 준비되어 있습니다
</body>
</html>