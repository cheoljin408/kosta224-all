<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax(JSONArray)</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
}
</style>
<script type="text/javascript">
	function startAjax() {
		let makerComp = document.getElementById("maker");
		if(makerComp.value==""){
			document.getElementById("carView").innerHTML ="";
			return;
		}
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				// alert(xhr.responseText);
				let ja = JSON.parse(xhr.responseText);
				// alert(ja[1].model);
				let tb = "";
				for(let i=0; i<ja.length; i++) {
					tb += "<tr>";
					tb += "<td>" + (i+1) + "</td>";
					tb += "<td>" + ja[i].model + "</td>";
					tb += "<td>" + ja[i].price + "</td>";
					tb += "</tr>";
				}
				document.getElementById("carView").innerHTML = tb;
			}
		}//callback
		xhr.open("get", "CarJSONServlet?maker=" + makerComp.value);
		xhr.send();
	}
</script>
</head>
<body>
	<select id="maker" onchange="startAjax()">
		<option value="">---</option>
		<option value="현대">현대</option>
		<option value="르노">르노</option>
		<option value="기아">기아</option>
	</select>
	<br>
	<br>
	<br>
	<br>
	<table>
		<thead>
			<tr>
				<th>NO</th>
				<th>MODEL</th>
				<th>PRICE</th>
			</tr>
		</thead>
		<tbody id="carView"></tbody>
	</table>
</body>
</html>




























