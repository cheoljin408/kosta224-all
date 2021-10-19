<%@page import="java.sql.*, javax.sql.*, model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		1. 기존의 db 커넥션을 생성하고 소멸시키는 방식의 커넥션 객체:
		<%
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String username = "scott";
		String password = "tiger";
		
		// 커넥션 생성
		Connection con = DriverManager.getConnection(url, username, password);
		%>
		<%=con.getClass() %>
		<%
		con.close();
		%>
		<br>
		<br>
		2. DBCP(Database Connection Pool)을 이용해 커넥션을 빌려오고 반납하는 방식의 커넥션 객체:
		<%
		DataSource ds = DataSourceManager.getInstance().getDataSource();
		
		// dbcp로부터 커넥션을 빌려온다
		Connection dbcpCon = ds.getConnection();
		%>
		<%=dbcpCon.getClass() %>
		<%
		// 커넥션을 dbcp에 반납한다
		dbcpCon.close();
		%>
	</body>
</html>