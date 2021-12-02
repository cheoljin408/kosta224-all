<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<title>jquery selector 연습</title>
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#btn2").click(function() {
				alert($(this).val() + " 클릭");
			});
			
			$("#btn3").click(function() {
				// alert($(this).val() + " 클릭");
				
				// jquery html(): innerHTML역할 HTML tag를 반영
				// $("#resultView").html("<font color=blue>" + $(this).val() + "</font>");
				// jquery text(): 오직 text로만 반영
				$("#resultView").html("<font color=blue>" + $(this).val() + "</font>");
			});
		});
	</script>
</head>
<body>
	<input type="button" value="테스트1"><br>
	<input type="button" value="테스트2" id="btn2"><br>
	<input type="button" value="테스트3" id="btn3"><br>
	<span id="resultView"></span>
</body>
</html>



















