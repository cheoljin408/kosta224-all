<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-hover table-bordered boardlist">
	<thead>
		<tr style="background-color: #d6f5d6">
			<th>번호</th>
			<th class="title">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.postList}" var="post">
			<tr>
				<td>${post.no}</td>
				<%-- 
						로그인한 상태이면 글제목에 링크를 부여해서 상세 글보기를 제공하고
						비로그인 상태이면 글제목만 제공한다
				 --%>
				<td>
					<c:choose>
						<c:when test="${sessionScope.mvo != null}">
							<a href="PostDetailController.do?no=${post.no}">${post.title}</a>
						</c:when>
						<c:otherwise>
							${post.title}
						</c:otherwise>
					</c:choose>
				</td>
				<td>${post.memberVO.name}</td>
				<td>${post.timePosted}</td>
				<td>${post.hits}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>