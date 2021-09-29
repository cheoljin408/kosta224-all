<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step2-2-querystring-action</title>
</head>
<body>
	client가 보낸 no: <%=request.getParameter("no") %>
	client가 보낸 food: <%=request.getParameter("food") %>
</body>
</html>