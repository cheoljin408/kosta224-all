<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>db sql date형 테스트</title>
	</head>
	<body>
<%--
		컨트롤러 영역 테스트를 위한 폼
		
					 @WebSerlvet("*.do")
		index.jsp -- FrontControllerServlet -- HandlerMapping -- Controller
																	|
																TestController
						| forward
					test-result.jsp
 --%>
 <!-- 
 		<form action="TestController.do" method="post">
			<button type="submit">전송</button>
		</form>
  -->
		<h3>MVC + Front Controller Design Pattern 상에 db date형 연습</h3>
<%--
		index.jsp -- FrontControllerServlet -- HandlerMapping -- FindProductByIdController -- ProductDAO -------------Database
							|																findProductById(id): ProductVO
				findbyid-fail.jsp(alert 후 다시 index로 이동)
					or
				findbyid-ok.jsp(검색된 상품 정보를 제공)
 --%>
		<form action="FindProductByIdController.do">
			<input type="number" name="productId" placeholder="상품아이디" required="required" >
			<button type="submit">검색</button>
		</form>
		<br>
		<br>
<%--
		index.jsp -- FrontControllerServlet -- HandlerMapping -- FindProductByIdController -- ProductDAO --------------Database
							|																registerProductById(ProductVO)
							| redirect
							|
				register-result.jsp
 --%>
		<form action="RegisterProductController.do" method="post">
			<input type="text" name="name" placeholder="상품명" required="required">
			<br>
			<input type="text" name="maker" placeholder="제조사" required="required">
			<br>
			<input type="number" name="price" placeholder="가격" required="required">
			<br>
			<button type="submit">등록</button>
			<button type="reset">리셋</button>
		</form>
		<br>
		<br>
<%--
		index.jsp -- FrontControllerServlet -- HandlerMapping -- AllProductListController -- ProductDAO --------------Database
							|																getAllProductList:ArrayList<ProductVO>
							| forward
							|
					product-list.jsp
					(상품 리스트 제공: 상품명, 제조사, 등록년, 월, 일 --> 상품아이디 내림차순)
 --%>
		<a href="AllProductListController.do">상품 리스트</a>
	</body>
</html>