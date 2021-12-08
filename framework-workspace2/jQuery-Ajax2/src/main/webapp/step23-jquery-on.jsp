<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>step23-jquery-on</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#createBtn").click(function() {
			let btn = "<input type='button' value='버튼' class='testBtn'><br>";
			$("#testDiv").append(btn);
		});
		
		// class testBtn button은 document ready 시점에는 존재하지 않는 요소이므로 아래와 같이 일반적인
		// 방식의 이벤트 처리는 동작되지 않는다 -> 동적으로 생성되는 요소에 대한 이벤트 처리는 jquery on으로 처리하면 된다
		/*
		$(".testBtn").click(function() {
			alert($(this).val);
		});
		*/
		
		// DOM load (document ready) 시점에 존재하지 않는 동적으로 생성되는 요소에 대한
		// 이벤트 핸들링(처리)은 jquery on 함수로 처리
		// $(셀렉터-이벤트 대상의 부모요소).on(이벤트타입, 대상요소, 이벤트 발생시 동작될 함수(콜백함수));
		$("#testDiv").on("click", ".testBtn", function() {
			alert($(this).val());
		});
	});
</script>
</head>
<body>
<div class="container">
<%-- 아래 버튼을 누르면 testDiv 영역에 동적으로 버튼을 생성한다 --%>
<input type="button" value="버튼생성" id="createBtn">
<hr>
<div id="testDiv"></div>
</div>
</body>
</html>








