<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step6-2-checkbox-action</title>
<link rel="stylesheet" type="text/css" href="css/home.css" />
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>NO</th>
				<th>MENU</th>
			</tr>
		</thead>
		<tbody>
			<%
			request.setCharacterEncoding("utf-8");
			String[] values = request.getParameterValues("menu");
			
			for(int i=0; i<values.length; i++) {
			%>
			<tr>
				<td><%=i+1 %></td>
				<td><%=values[i] %></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>