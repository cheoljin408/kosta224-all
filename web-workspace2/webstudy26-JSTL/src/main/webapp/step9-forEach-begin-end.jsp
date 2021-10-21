<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>step9-forEach-begin-end</title>
	</head>
	<body>
		<c:forEach begin="1" end="10" var="page">
			${page}
		</c:forEach>
		<br><br>
		<%
		// 컨트롤러에서 공유했다고 가정
		request.setAttribute("startPage", 11);
		request.setAttribute("endPage", 15);
		request.setAttribute("nowPage", 13);
		%>
		startPage와 endPage까지 page정보를 출력<br>
		<c:forEach begin="${requestScope.startPage}" end="${requestScope.endPage}" var="page">
			<c:choose>
				<c:when test="${page == requestScope.nowPage}">
					${page}
				</c:when>
				<c:otherwise>
					<a href="">${page}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</body>
</html>