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
<title>step20-jquery-event</title>
</head>
<body>
<div class="container">
<input type="checkbox" id="termsChk">동의<br>
<a href="http://daum.net" class="testEvent">다음으로</a>
<%--
		id termsChk 동의 체크박스에 체크 상태가 되어야만 다음페이지로 이동하게 한다 
		체크 상태가 아니면 alert() 으로 약관에 동의하셔야 다음페이지로 이동할 수 있습니다 메세지 보여주고
		이동시키지 않는다  
 --%>
<script type="text/javascript">
	$(function() {
		$(".testEvent").click(function(event) {
			alert($("#termsChk").prop("checked"));
			
			if($("#termsChk").prop("checked") == false) {
				alert("약관에 동의하셔야 다음 페이지로 이동할 수 있습니다");
				event.preventDefault();
			}
		});
	});
</script>
</div>
</body>
</html>




























