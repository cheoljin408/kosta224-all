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
<title>step21-select-option</title>
<script type="text/javascript">
	$(function() {
		let arr = ["손흥민", "이강인", "황의조"];
		$("#createOption").click(function() {
			$("#friend").empty();
			for(let i=0; i<arr.length; i++) {
				$("#friend").append("<option value=" + arr[i] + ">" + arr[i] + "</option>");
			}
		});
		
		$("#deleteOption").click(function() {
			$("#friend").empty();
		});
		
		$("#setBtn").click(function() {
			let set = new Set();
			set.add("손흥민");
			set.add("황의조");
			set.add("황의조");
			set.add("손흥민");
			alert(set.size);
			for(let data of set) {
				alert(data);
			}
		});
	});
</script>
</head>
<body>
<div class="container">
<input type="button" value="셀렉트옵션생성" id="createOption">
<input type="button" value="셀렉트옵션삭제" id="deleteOption">
<select id="friend"></select>
<hr>
<input type="button" value="set-test" id="setBtn">
</div>
</body>
</html>
















