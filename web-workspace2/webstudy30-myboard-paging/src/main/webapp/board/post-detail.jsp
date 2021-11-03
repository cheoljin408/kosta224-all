<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table">
	<tr>
		<td>글번호 ${pvo.no}</td>
		<td>제목 ${pvo.title}</td>
		<td>작성자 ${pvo.memberVO.name}</td>
		<td>조회수 ${pvo.hits}</td>
		<td><%-- 작성일시 2021.10.29 --%></td>
	</tr>
	<tr>
		<td colspan="5">
			<%-- pre: db에 저장된 글형식 그대로 표현 --%>
			<pre><font size="4">${pvo.content}</font></pre>
		</td>
	</tr>
	<%--
			글쓴이가 로그인한 회원이면 하단부에 삭제와 수정 버튼을 제공한다
			게시물의 글쓴이 회원 아이디와 로그인한 회원(세션에 저장된)아이디가 같으면
			수정과 삭제 버튼을 보여준다
	--%>
	<c:if test="${requestScope.pvo.memberVO.id == sessionScope.mvo.id}">
		<tr>
			<td colspan="5" class="text-center">
				<script type="text/javascript">
					const deletePost = () => {
						if(confirm("삭제하시겠습니까?")) {
							document.getElementById("deleteForm").submit();
						}
					}
					
					const updatePost = () => {
						if(confirm("수정하시겠습니까?")) {
							document.getElementById("updateForm").submit();
						}
					}
				</script>
				<form action="DeletePostController.do" method="post" id="deleteForm">
					<input type="hidden" name="no" value="${pvo.no}">
				</form>
				<form action="UpdatePostFormController.do" method="post" id="updateForm">
					<input type="hidden" name="no" value="${pvo.no}">
				</form>
				<button type="button" class="nutton btn-success" onclick="deletePost()">삭제</button>
				<button type="button" class="nutton btn-success" onclick="updatePost()">수정</button>
			</td>
		</tr>
	</c:if>
</table>