<%@page import="model.MemberVO"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findMemberById-action</title>
</head>
<body>
	<%--
			findMemberById-form.jsp의 폼으로부터 회원 아이디를 전달받는다
			MemberDAO 의 findMemeberById(String id): MemberVO 메소드를 구현한 후
			이 메소드를 이용해 전달받는 아이디에 대한 회원 정보를 반환받는다
			
			회원정보가 존재하면
			아이디: jsp
			이름: 아이유
			주소: 오리
			
			존재하지 않으면(null이 리턴될 경우)
			javascript alert로 ~아이디에 대한 회원정보가 없습니다! 를 보여주고 확인을 누르면
			findMemberById-form.jsp로 다시 이동시킨다(javascript location.href=""를 이용)
			
			구현순서: MemberDAO 의 findMemberById() 메소드 구현 -> findMemberById-action 구현
	--%>
	<%
	MemberDAO dao = new MemberDAO();
	MemberVO vo = dao.findMemberById(request.getParameter("memberId"));
	if(vo != null) {
	%>
	<h3>아이디:<%=vo.getId() %></h3>
	<h3>이름:<%=vo.getName() %></h3>
	<h3>주소:<%=vo.getAddress() %></h3>
	<%
	}
	else {
	%>
	<script>
		let memberId = "<%=request.getParameter("memberId") %>"
		alert(`\${memberId} 아이디에대한 회원정보가 없습니다!`);
		location.href="findMemberById-form.jsp";
	</script>
	<%
	}
	%>
</body>
</html>