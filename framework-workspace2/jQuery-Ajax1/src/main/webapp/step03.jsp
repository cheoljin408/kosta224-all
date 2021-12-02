<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<title>jquery basic</title>
</head>
<body>
	<script type="text/javascript">
		// 이 시점에는 testSpan이 로드되어있지 않기 때문에 null
		alert(document.getElementById("testSpan"));
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			alert(document.getElementById("testSpan"));
		});
	</script>
	<span id="testSpan">즐공</span>
	<script type="text/javascript">
		// 이 시점에는 testSpan이 로드되어있기 때문에 Object
		alert(document.getElementById("testSpan"));
	</script>
</body>
</html>










