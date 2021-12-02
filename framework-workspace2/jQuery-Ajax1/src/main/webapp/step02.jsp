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
		$(document).ready(function() {
			$(":button").click(function() {
				alert("버튼 클릭");
			});
		});
	</script>
	<input type="button" value="버튼1"><br>
	<input type="button" value="버튼2"><br>
	<input type="button" value="버튼3"><br>
	<input type="submit" value="전송버튼"><br>
</body>
</html>




