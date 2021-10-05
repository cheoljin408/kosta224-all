<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model2 MVC</title>
</head>
<body>
	<h3>Model2 MVC</h3>
	<%--
			client ---> AllmemberCountServlet <--> MemberDAO <--> Database
							|
							| forward
						allmembercount.jsp
	--%>
	<ul>
		<li><a href="AllMemberCountServlet">총 회원수 조회</a></li>
		<li><a href="findMemberById-form.jsp">아이디로 회원검색</a></li>
	</ul>
	<img src="Model2-1.png" />
	<img src="forward-redirect.png" />
</body>
</html>