<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward-result</title>
</head>
<body bgcolor="yellow">
	forward-result view page
	<%-- forward 방식이므로 request에 저장한 정보를 이용할 수 있다 --%>
	<%=request.getAttribute("shareInfo") %>
</body>
</html>