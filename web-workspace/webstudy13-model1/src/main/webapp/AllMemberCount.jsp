<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AllMemberCount</title>
</head>
<body>
	<%-- Model1 Architecture 회원수 조회 --%>
	<%
	MemberDAO dao = new MemberDAO();
	int count = dao.getTotalCount();
	%>
	<h4>총 회원수 <%=count %>명</h4>
</body>
</html>