<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("김치찌개");
	list.add("큐브스테이크");
	list.add("감자찜");
	list.add("생선찜");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp table 연습</title>
<link rel="stylesheet" type="text/css" href="css/home.css" />
</head>
<body>
	<table border="1">
		<%
		for(int i=0; i<list.size(); i++) {
		%>
		<tr>
			<td><%=i %></td>
			<td><%=list.get(i) %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>