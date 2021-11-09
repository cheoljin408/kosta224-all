<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>step3-anonymous-arrow-function</title>
</head>
<body>
	<h3>자바스크립트 익명함수(anonymous function)와 화살표함수(arrow function)</h3>
	<script type="text/javascript">
		/*
		function hello() {
			alert("hello 일반함수")
		}
		
		hello();
		*/
		/*
		let hello = function() {
			alert("hello 익명함수");
		}
		
		hello();
		*/
		
		// 아래 두 구문을 실행하는 시점에는 infoDiv는 존재하지 않는 상태이므로 error
		// alert(document.getElementById("infoDiv"));
		// alert(document.getElementById("infoDiv").innerHTML);
		
		// window.onload: 웹 페이지가 완전히 로드 된 후 발생하는 이벤트
		/*
		window.onload = hi;
		function hi() {
			alert("hi " + document.getElementById("infoDiv").innerHTML);
		}
		*/
		
		// window onload에 익명함수 (anonymous function)로 등록
		/*
		window.onload = function() {
			alert("hi 익명함수 " + document.getElementById("infoDiv").innerHTML);
		}*/
		
		// window onload에 화살표 함수(arrow function) 로 등록
		window.onload = () = > {
			alert("hi 화살표함수 " + document.getElementById("infoDiv").innerHTML);
		}
	</script>
	<br><br>
	<div id="infoDiv">
		익명함수와 화살표함수를 테스트
	</div>
</body>
</html>