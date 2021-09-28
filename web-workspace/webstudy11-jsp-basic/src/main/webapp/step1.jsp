<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step1 jsp basic</title>
</head>
<body>
	<!-- html 주석 -->
	<%-- jsp 주석: client 측에 전달되지 않는다 --%>
	jsp 주석
	<br>
	<br>
	<%
	// 아래 코드는 service 메소드에 삽입된다
	for (int i = 0; i < 10; i++) {
	%>
	<font color="green" size="5"><%=i+1 %>. 가을전어회</font><br>
	<%
	}
	%>
	<br><br>
	<%-- 인스턴스 변수 선언 --%>
	<%!
	private int count;
	%>
	<%-- service 메소드 내에 out.print(count++)로 코드가 생성 --%>
	접속수 <%=count++ %>
</body>
</html>