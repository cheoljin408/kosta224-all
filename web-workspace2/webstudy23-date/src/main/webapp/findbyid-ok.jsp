<%@page import="org.kosta.webstudy23.model.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>findbyid-ok</title>
	</head>
	<body>
	<%
	ProductVO productVO = (ProductVO)request.getAttribute("productVO");
	%>
		<a href="index.jsp">Home</a>
		<br>
		<br>
		상품 검색 결과
		<br>	
		<br>
		아이디:<%=productVO.getId() %>
		<br>
		상품명:<%=productVO.getName() %>
		<br>
		제조사:<%=productVO.getMaker() %>
		<br>
		가격:<%=productVO.getPrice() %>
		<br>
		등록일시:<%=productVO.getRegDate() %>
		<br>
	</body>
</html>