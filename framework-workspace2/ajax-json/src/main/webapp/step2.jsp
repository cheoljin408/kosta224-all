<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSONArray를 이용해 ajax 통신하는 예제</title>
<script type="text/javascript">
	function startAjax() {
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
			
			}
		}//callback
		xhr.open("get", "JSONArrayServlet");
		xhr.send();
	}
	function clearPlayer() {
		document.getElementById("player").innerHTML="";
	}
</script>
</head>
<body>
<input type="button" value="JSONArray확인" onclick="startAjax()">
<input type="button" value="비우기" onclick="clearPlayer()">
<table border="1">
	<thead>
		<tr>
			<th>선수명</th>
		</tr>
	</thead>
	<tbody id="player"></tbody>
</table>
</body>
</html>





























