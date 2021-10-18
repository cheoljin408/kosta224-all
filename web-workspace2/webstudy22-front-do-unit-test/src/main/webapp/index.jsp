<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>do test</title>
	</head>
	<body>
		<h3>client 요청방식 *.do에 대한 단위 테스트</h3>
<%--
		요청 url이 .do로 마치는 것은 모두 FrontControllerServlet이 처리하도록 설정하여 테스트 해본다
 --%>
		<a href="FindController.do">조회</a>
		<form action="RegisterController.do">
			<button>등록</button>
		</form>
	</body>
</html>