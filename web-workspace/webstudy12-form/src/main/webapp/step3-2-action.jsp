<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step3-2-action</title>
</head>
<body>
	<%
	// post 요청 메소드 일때는 별도의 한글 처리가 필요
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("userName");
	int age = Integer.parseInt(request.getParameter("userAge"));
	String checkAge = "";
	
	if(age >= 19)
		checkAge = "성인";
	else
		checkAge = "미성년";
	%>
	<%=checkAge %><br>
	이름: <%=name %><br>
	나이: <%=age %><br>
</body>
</html>