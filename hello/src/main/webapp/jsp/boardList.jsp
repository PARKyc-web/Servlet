<%@page import="com.tst.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List JSP</title>
</head>
<body>


	<%
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.boardList();
	%>

	<c:choose>
		<c:when test="${!empty loginId}">
			<h3>
				<c:out value="${loginId}"></c:out>
				님 로그인되었습니다!
			</h3>
		</c:when>
		<c:otherwise>
			<h3>현재 손님으로 로그인되었습니다!</h3>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${empty loginId}">
		<a href="loginInfo.jsp">로그인</a>
	</c:if>
	
	<c:if test="${!empty loginId}">
		<a href="logout.jsp">로그아웃</a>
	</c:if>

	<form action="boardDetail.jsp" method="get">
		조회할 글번호: <input type="text" name="id"> <input type="submit"
			value="조회"><br>
		<br>
	</form>
	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>방문횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="boards" value="<%=list%>"></c:set>
			<c:forEach var="vo" items="${boards}">
				<tr>
					<td><a href="boardDetail.jsp?id=${vo.boardId}">${vo.boardId}</a></td>
					<td>${vo.title}</td>
					<td>${vo.writer}</td>
					<td>${vo.createDate}</td>
					<td>${vo.cnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="addBoard.jsp">글 등록하기</a>
	

	
</body>
</html>