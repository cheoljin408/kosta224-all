<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%> <%-- isErrorPage: 에러페이지임을 알린다 --%>
<%
	// exception 객체는 isErrorPage="true" 일때 사용할 수 있다
	exception.printStackTrace(); // 예외 메세지와 발생 경로를 콘솔에 출력한다
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공사중</title>
</head>
<body>
	<%-- jsp에서 에러가 발생하면 현 페이지를 클라이언트에게 보여준다 --%>
	<img src="images/gong.png" />
</body>
</html>