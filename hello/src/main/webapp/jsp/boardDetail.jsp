<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%		
		String id = request.getParameter("id");	
	
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(Integer.parseInt(id));
	%>
	
	<c:set var="board" value="<%=vo%>"></c:set>	
	<table border="1">
		<tbody>		
		<tr>
			<td>글 번호</td>
			<td>${board.boardId}</td>
		</tr>				
		<tr>
			<td>글 제목</td>
			<td>${board.title}</td>
		</tr>	
		<tr>
			<td>내용</td>
			<td>${board.content}</td>
		</tr>						
		<tr>
			<td>작성자</td>
			<td>${board.writer}</td>
		</tr>						
		<tr>
			<td>작성일자</td>
			<td>${board.createDate}</td>
		</tr>		
		<tr>
			<td>방문횟수</td>
			<td>${board.cnt}</td>
		</tr>
		
	</tbody>
	</table>
	
	<c:set var="login" value="${loginId}"></c:set>
	<c:choose>
		<c:when test="${empty login || board.writer != login}">
			<br><a href="boardList.jsp">뒤로가기</a>
		</c:when>
		
		<c:otherwise>
			<br><a href="boardList.jsp">뒤로가기</a>
			<br><a href="updateForm.jsp?bno=${board.boardId}">수정하기</a>
			<br><a href="deleteForm.jsp?bno=${board.boardId}">삭제하기</a>
		</c:otherwise>
	</c:choose>
	
</body>
</html>