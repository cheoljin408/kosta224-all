<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>미디어 쿼리</title>
	<style type="text/css">
		body {
			background-color: olive;
		}

		@media(min-width: 576px)  {
			body {
				background-color: red;
			}
		}
		
		@media(min-width: 768px)  {
			body {
				background-color: yellow;
			}
		}

		@media(min-width: 992px)  {
			body {
				background-color: lime;
			}
		}
		
		@media(min-width: 1200px)  {
			body {
				background-color: orange;
			}
		}
	</style>
</head>
<body>
	
</body>
</html>