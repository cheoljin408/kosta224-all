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
<title>step19-jquery-event</title>
<style type="text/css">
	.pro{
		background-color: lime;
	}
	.inner{
		background-color: orange;
	}
</style>
<script type="text/javascript">
	$(function() {
		$(".pro").click(function(event) {
			// 이벤트 버블링: 이벤트가 전파되는 현상, pro inner class 영역을 클릭했을 때 이벤트가 전파되어 alert가 두 번 발생
			alert($(this).html());
			event.stopPropagation();
		});
	});
</script>
</head>
<body>
<div class="container">
	<div class="pro">
		pro class div 영역 <br><br>
		<div class="pro inner">
			pro inner class div 영역 
		</div>
	</div>
</div>
</body>
</html>



















