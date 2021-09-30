<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step6-1-checkbox</title>
</head>
<body>
	<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("마라탕");
	list.add("라면");
	list.add("닭강정");
	%>
	<script type="text/javascript">
		function checkMenu() {
			let menus = document.getElementsByName("menu");
			let flag = false;
			
			for(let i=0; i<menus.length; i++) {
				if(menus[i].checked) {
					flag = true;
					break;
				}
			}
			if(flag === false) {
				alert("메뉴를 선택하세요!");
				return false;
			}
		}
	</script>
	<form action="step6-2-checkbox-action.jsp" mothod="get" onsubmit="return checkMenu()">
		<%
		for(int i=0; i<list.size(); i++) {
		%>
		<input type="checkbox" name="menu" value="<%=list.get(i) %>" /><%=list.get(i) %><br>
		<%
		}
		%>
		<input type="submit" value="주문" />
	</form>
	<%--
		step1.
		javascript로 checkbox에 하나 이상 체크가 되어 있지 않으면
		alert()으로 메뉴를 선택하세요 후 전송시키지 않는다
		
		step2.
		step6-2-checkbox-action.jsp에서 테이블 형식으로 선택한 메뉴를 보여준다
	--%>
</body>
</html>