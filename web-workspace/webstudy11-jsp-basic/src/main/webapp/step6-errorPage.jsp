<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%-- errorPage: 현 jsp에서 error가 발생하면 지정한 jsp로 클라이언트에게 응답하게 하는 설정 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>errorPage 설정 테스트</title>
</head>
<body>
	<%
	String name = "아이유";
	
	// 테스트를 위해서 고의로 예외를 발생시켜 본다
	name = null;
	%>
	이름은 <%=name.length() %>자로 구성되어 있습니다
</body>
</html>