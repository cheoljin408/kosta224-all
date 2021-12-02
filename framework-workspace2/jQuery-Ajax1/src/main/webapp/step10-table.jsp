<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>jquery table</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#testBtn").click(function() {
			// alert($(this).val());
			
			// id가 friend인 tbody의 하위 tr들을 선택
			// $("#friend tr").css("background", "yellow");
			// alert($("#friend tr").html());
			
			// tbody id friend의 하위 tr중 세번째 tr를 선택
			// $("#friend tr:eq(2)").css("background", "yellow");
			
			// td중 당이라는 문자열이 포함된 td만 선택
			$("#friend td:contains(당)").css("background", "yellow");
		});
		
		// friend id tbody의 하위 td가 클릭되었을 때 자신의 텍스트가 alert로 출력
		$("#friend td").click(function() {
			alert($(this).text());
			
			// 클릭된 td요소의 상위 tr로 이동해서 그 tr이 가진 하위 요소 첫번째 td를 select해서 text를 출력
			let info = $(this).parent().children().eq(0).text();
			alert(info);
		});
	});
</script>
</head>
<body>
	<div class="container">
		<input type="button" value="테스트" id="testBtn">
		<p>jquery로 table 제어</p>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>이름</th>
					<th>나이</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody id="friend">
				<tr>
					<td>아이유</td>
					<td>28</td>
					<td>동탄</td>
				</tr>
				<tr>
					<td>김연아</td>
					<td>24</td>
					<td>사당</td>
				</tr>
				<tr>
					<td>김태리</td>
					<td>27</td>
					<td>분당</td>
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>