<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step5-1-select</title>
</head>
<body>
	<%-- submit 없이 option을 선택한 즉시 서버로 전송되도록 javascript onchange 이벤트 속성을 이용해본다 --%>
	<script type="text/javascript">
		function sendLine() {
			let lineComp = document.getElementById("line");
			if(lineComp.value != "") {
				// alert(lineComp.value);
				// subway id form을 submit 한다
				document.getElementById("subway").submit();
			}
			
		}
	</script>
	<form action="step5-2-select-action.jsp" id="subway">
		<select name="line" id="line" required="required" onchange="sendLine()">
			<option value="">-호선-</option>
			<%
			for(int i=1; i<10; i++) {
			%>
			<option value="<%=i %>"><%=i %>호선</option>
			<%
			}
			%>
		</select>
		<!-- <button type="submit">선택</button> -->
	</form>
	<%--
			jsp for loop을 이용해서 1호선 ~ 9호선 까지 옵션을 생성한다
			
			실제 전송 정보는 호선을 제외한 1~9까지의 정보가 전송된다
			
			선택submit을 누르면
			step5-2-select-action.jsp
			
			1~4호선까지는 코레일 3호선 선택하겠습니다
			5~9호선까지는 도시철도 6호선 선택하셨습니다 로 응답하게 만든다
	 --%>
</body>
</html>