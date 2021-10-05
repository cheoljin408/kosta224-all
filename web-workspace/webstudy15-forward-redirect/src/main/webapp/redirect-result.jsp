<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect-result</title>
</head>
<body bgcolor="orange">
	redirect-result view page
	<%-- redirect 방식은 아래와 같이 request에 저장된 정보를 사용할 수 없다 --%>
	<%=request.getAttribute("shareInfo") %>
</body>
</html>