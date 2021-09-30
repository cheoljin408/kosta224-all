<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("짜장면");
	list.add("짬뽕");
	list.add("탕수육");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>radio</title>
</head>
<body>
	<form method="post" action="step4-2-radio-action.jsp">
		<%
		for(int i=0; i<list.size(); i++) {
		%>
		<input type="radio" name="menu" value=<%=list.get(i) %> required="required" /><%=list.get(i) %><br>
		<%
		}
		%>
		<input type="submit" value="전송" />
	</form>
</body>
</html>