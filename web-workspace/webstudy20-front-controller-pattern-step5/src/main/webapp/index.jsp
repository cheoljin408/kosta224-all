<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Web MVC, FrontController</title>
	</head>
<%--
		index.jsp --- FrontControllerServlet --- FindCustomerByIdController --- DAO --- DB
						|
					findbyid-ok.jsp
					or
					findbyid-fail.jsp
 --%>
	<body>
		<h3>Model2 Architecture MVC, Singleton, Front Controller Design Pattern</h3>
		<form action="FrontControllerServlet" method="get">
			<input type="hidden" name="command" value="FindCustomerByIdController" >
			<input type="text" name="id" placeholder="고객아이디" required="required" >
			<button type="submit">검색</button>
		</form>
		<br>
		<br>
		<form action="FrontControllerServlet" method="post">
			<input type="hidden" name="command" value="RegisterCustomerController" >
			<input type="text" name="customerInfo" placeholder="고객정보" required="required" >
			<button type="submit">등록</button>
		</form>
		<br>
		<br>
		<form action="FrontControllerServlet" method="post">
			<input type="hidden" name="command" value="UpdateCustomerController" >
			<input type="text" name="customerInfo" placeholder="고객정보" required="required" >
			<button type="submit">수정</button>
		</form>
		<br>
		<br>
		<form action="FrontControllerServlet" method="post">
			<input type="hidden" name="command" value="DeleteCustomerController" >
			<input type="text" name="customerId" placeholder="고객아이디" required="required" >
			<button type="submit">삭제</button>
		</form>
		<br>
		<br>
		<img src="image/frontcontroller.png">
	</body>
</html>