<%@page import="com.tst.board.BoardDAO"%>
<%@page import="com.tst.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateForm JSP</title>
</head>
<body>

	<%
	request.setCharacterEncoding("UTF-8");
	
	String bno = request.getParameter("bno");
	BoardDAO dao = new BoardDAO();
	BoardVO vo = dao.getBoard(Integer.parseInt(bno));
	%>

	<form action="update.jsp" method="post">
		<table border="1">
			<tr>
				<th>글번호</th>
				<td><input type="text" value="<%=vo.getBoardId()%>" name="bid" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" value="<%=vo.getTitle()%>" name="bTitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" value="<%=vo.getContent()%>" name="bContent"></td>
			</tr>
		</table>
		<input type="submit" value="글 수정">
	</form>


</body>
</html>