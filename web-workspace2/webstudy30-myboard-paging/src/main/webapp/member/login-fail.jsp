<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		alert("로그인 되지 않았습니다");
		// location.href="../ListController.do"; // home으로 보낸다
		location.href="${pageContext.request.contextPath}/ListController.do";
	</script>
	<%-- ${pageContext.request.contextPath} --%>
</body>
</html>