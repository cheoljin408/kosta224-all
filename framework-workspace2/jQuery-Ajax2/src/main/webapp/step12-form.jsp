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
<title>jquery form 요소 제어</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#testForm").submit(function() {
			// get value: userId 텍스트 입력양식에 접근해서 사용자가 입력한 value를 확인한다
			// alert($("#userId").val());
			
			// set value
			// $("#userId").val("하하").focus();
			
			// select option value를 alert로 출력
			// alert("선택한 통신사:" + $("#hp").val());
			
			// radio 입력양식은 특성상 동일한 name으로 여러개 정의된다
			// testForm id의 form 요소 중 radio name이 gender인 대상을 선택해서
			// 만약 사용자가 하나도 선택하지 않으면 alert으로 성별을 선택하세요
			// 선택했으면 선택한 라디오 버튼의 value를 alert으로 보여준다
			/*
			let ra = $("#testForm :radio[name=gender]:checked");
			if(ra.length == 0) {
				alert("성별을 선택하세요");
			} else {
				alert(ra.val());
			}*/
			
			// testForm id form 하위의 checkbox중 name이 hobby인 대상을
			// 사용자가 하나 이상 체크하지 않으면 alert()으로 취미를 선택하세요
			// 하나 이상 체크했으면 체크한 체크박스의 value를 alert으로 보여준다
			let ha = $("#testForm :checkbox[name=hobby]:checked");
			
			if(ha.length == 0) {
				alert("취미를 선택하세요");
			} else {
				// 체크박스는 다중 선택이 가능하므로 배열을 for loop으로 실행시켜 value를 확인
				for(let i=0; i<ha.length; i++) {
					// ha[i].val();
					// ha는 jquery 객체지만 ha[i] 요소는 javascript 객체, 즉 jquery 함수 val()을 적용하기 위해서는 jquery로 다시 표현해야 한다
					console.log(ha);
					alert($(ha[i]).val());
				}
			}
			
			// return confirm("전송하시겠습니까?");
			return false;
		});
	});
</script>
</head>
<body>
<div class="container">
<form action="test.jsp" id="testForm">
 아이디 <input type="text" id="userId" name="userId"><br><br>
 <select id="hp">
  <option value="">--</option>
  <option value="sk">sk</option>
  <option value="kt">kt</option>
  <option value="lg">lg</option>
 </select><br><br>
 <input type="radio" name="gender" value="male">남 
 <input type="radio" name="gender" value="female">여 
 <br><br><br>
 <input type="checkbox" name="hobby" value="노래">노래<br>
 <input type="checkbox" name="hobby" value="코딩">코딩<br>
 <input type="checkbox" name="hobby" value="독서">독서<br>
 <input type="submit" value="전송">
</form>
</div>
</body>
</html>