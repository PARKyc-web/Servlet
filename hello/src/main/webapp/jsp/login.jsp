<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login JSP</title>
</head>
<body>
	
	<%
		String id = request.getParameter("id");
		String pwd = request.getParameter("passwd");
		
		BoardDAO dao = new BoardDAO();
		
		if(dao.loginCheck(id, pwd) == null){
			response.sendRedirect("loginInfo.jsp");
			
		} else{			
			session.setAttribute("loginId", id);
			response.sendRedirect("boardList.jsp");			
		}
	%>
	
</body>
</html>