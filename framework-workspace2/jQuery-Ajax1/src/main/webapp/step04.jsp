<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<title>jquery basic class를 이용한 셀렉터</title>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".ct").click(function() {
				// this는 현재 이벤트가 발생된 요소 객체, jquery text()는 요소가 가지고 있는 텍스트 정보
				return confirm($(this).text() + " 이동하시겠습니까?");
			});
		});
	</script>
</head>
<body>
	<a href="http://daum.net" class="ct">다음넷으로</a><br>
	<a href="http://naver.com">네이버로</a><br>
	<a href="http://google.com" class="ct">구글로</a>
	<%-- ct class 요소들만 클릭했을 때 confirm으로 확인해서 확인버튼 누르면 이동, 취소 누르면 이동하지 않는다  --%>
</body>
</html>



