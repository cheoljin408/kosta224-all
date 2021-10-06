<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%> <%-- session="false" -> session을 자동 생성하지 않도록 설정 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session-test4</title>
</head>
<body>
	<%--
			지시자 태그에서 세션을 자동 생성하지 않도록 설정했으므로 아래와 같이 error가 난다
	 --%>
	<%-- <%=session %> --%>
	세션을 자동생성하지 않도록 설정<br><br>
	<%--
			필요시 세션을 생성하기 위해서는 아래와 같이 기술하면 된다
	 --%>
	 <%
	 HttpSession session = request.getSession();
	 %>
	 <%=session.getId() %>
</body>
</html>