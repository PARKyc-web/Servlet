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
		String bno = request.getParameter("bno");
	
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(Integer.parseInt(bno));
	%>	
	<c:redirect url="boardList.jsp"></c:redirect>
	
</body>
</html>