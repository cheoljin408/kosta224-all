<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>server jsp</title>
</head>
<body>
	<!-- 
		jsp는 지금 수업 하는 내용은 아닙니다
		step13-submit.html의 form에서 submit 했을 때 서버가 응답한다는 것을 단지 확인하기 위한 것이고
		이후에 자세히 수업한다
	 -->
	 서버에서 정보를 전달받아 응답한다 <br><br>
	 별명:<%=request.getParameter("nick") %> 나이:<%=request.getParameter("age") %>
</body>
</html>