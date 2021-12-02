<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>jquery css 셀렉터</title>
<style type="text/css">
	.a{
		background-color: yellow;
	}
	.b{
		background-color: lime;
	}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$(".food li").click(function() {
			alert($(this).text() + "");
		});
	});
</script>
</head>
<body>
<ol class="a food">
	<li>갈비</li>
	<li>치킨</li>
	<li>광어</li>
</ol>
<ol class="food b">
	<li>소주</li>
	<li>맥주</li>
	<li>와인</li>
</ol>
<ol>
	<li>남한산성</li>
	<li>하와이</li>
	<li>제주도</li>
</ol>
</body>
</html>







