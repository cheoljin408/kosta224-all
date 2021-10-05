<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp와 db연동</title>
</head>
<body>
	<%
	String driver = "oracle.jdbc.OracleDriver";
	Class.forName(driver);
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	Connection con = DriverManager.getConnection(url, "scott", "tiger");
	String sql = "select count(*) from member";
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	int count = 0;
	if(rs.next()) {
		count = rs.getInt(1);
	}
	rs.close();
	pstmt.close();
	con.close();
	%>
	<h3>초기 웹 개발방식: jsp와 database연동</h3>
	<h4>총 회원수 <%=count %>명</h4>
</body>
</html>