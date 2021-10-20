<%@page import="model.TestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step3-Model-EL</title>
</head>
<body>
<%
	TestVO tvo=new TestVO();
	request.setAttribute("testVO", tvo);
%>
<%--
		jsp EL 에서 Model의 class 속성에 접근해보는 예제 
		-> EL 은 Model 객체의 get 계열 메서드와 is 계열 메서드에만 접근 가능  
 --%>

${requestScope.testVO} <br>
<%-- TestVO의 getName() 메서드가 실행되어 반환된 값이 출력 --%>
${requestScope.testVO.name} <br>
<%-- error : TestVO의 findInfo() 메서드이므로 접근불가 --%>
<%-- ${requestScope.testVO.info} --%>
<BR>
<%-- 접근가능 : TestVO의 isExist() 메서드가 실행되어 반환된 값이 출력 --%>
${requestScope.testVO.exist}
</body>
</html>
















