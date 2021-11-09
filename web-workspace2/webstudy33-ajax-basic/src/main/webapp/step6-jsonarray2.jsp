<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ajax(JSON을 이용하여 통신)</title>
	<script type="text/javascript">
		function startAjax() {
			let xhr = new XMLHttpRequest();
			xhr.onload = () => {
				let json = JSON.parse(xhr.responseText);
				console.log(json);
				for(let i=0; i<json.length; i++) {
					alert(json[i].model + " " + json[i].price);
				}
			}
			xhr.open("get", `JSONArrayServlet2`);
			xhr.send();
		}
	</script>
</head>
<body>
	<button onclick="startAjax()">JSONArray Test</button>
</body>
</html>










