<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>findbyid-fail</title>
	</head>
	<body>
		회원 아이디가 존재하지 않습니다
		<script type="text/javascript">
			alert("<%=request.getParameter("productId") %>회원 아이디가 존재하지 않습니다");
			location.href="index.jsp";
		</script>
	</body>
</html>