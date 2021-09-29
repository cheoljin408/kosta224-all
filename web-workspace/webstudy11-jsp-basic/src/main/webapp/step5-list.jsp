<%@page import="model.FoodVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<FoodVO> list = new ArrayList<FoodVO>();
	list.add(new FoodVO("신라면", "농심", 1500));
	list.add(new FoodVO("진라면", "오뚜기", 1300));
	list.add(new FoodVO("참이슬", "진로", 1400));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp list 표현</title>
<link rel="stylesheet" type="text/css" href="css/home.css" />
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>순번</th>
				<th>이름</th>
				<th>제조사</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(int i=0; i<list.size(); i++) { 
			%>
			<tr>
				<td><%=i+1 %></td>
				<td><%=list.get(i).getName() %></td>
				<td><%=list.get(i).getMaker() %></td>
				<td><%=list.get(i).getPrice() %></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>