<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step5-2-select-action</title>
</head>
<body>
	<%
	int line = Integer.parseInt(request.getParameter("line"));
	String company = "";
	
	if(line >= 1 && line <= 4)
		company = "코레일";
	else
		company = "도시철도";
	%>
	<%=company %> <%=line %>호선 선택하셨습니다
</body>
</html>