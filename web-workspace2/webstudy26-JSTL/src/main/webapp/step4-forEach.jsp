<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>step4-forEach</title>
	</head>
	<body>
<%
	String friends[] = {"이강인", "손흥민", "황의조"};
	request.setAttribute("fa", friends);
%>
<%--
		jstl forEach
		items: 저장된 배열 또는 컬렉션(list or map)
		var: 요소를 저장할 변수
		varStatus: index와 count 속성
				   index는 0부터 시작
				   count는 1부터 시작
--%>
		<c:forEach items="${requestScope.fa}" var="f" varStatus="order">
			${f}, index: ${order.index}, count: ${order.count}<br>
		</c:forEach>
	</body>
</html>