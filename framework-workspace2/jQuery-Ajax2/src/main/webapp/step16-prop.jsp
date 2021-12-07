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
<title>step16-prop</title>
<script type="text/javascript">
	$(function() {
		// checkBtn1 버튼을 클릭하면 체크박스 amiling이 체크상태가 되도록 이벤트 핸들러를 등록
		$("#checkBtn1").click(function() {
			$("#mailing").prop("checked", true);
		});
		$("#checkBtn2").click(function() {
			$("#mailing").prop("checked", false);
		});
		$("#checkBtn3").click(function() {
			alert($("#mailing").prop("checked"));
		});
	});
</script>
</head>
<body>
<div class="container">
<input type="checkbox" id="mailing">메일체크<br>
<input type="button" id="checkBtn1" value="체크하기">
<input type="button" id="checkBtn2" value="체크해제하기">
<input type="button" id="checkBtn3" value="체크상태확인">
</div>
</body>
</html>











