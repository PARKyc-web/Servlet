<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("bid");
		String title = request.getParameter("bTitle");
		String content = request.getParameter("bContent");
		
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		
		vo.setBoardId(Integer.parseInt(id));
		vo.setTitle(title);
		vo.setContent(content);
		
		dao.updateBoard(vo);
		
		response.sendRedirect("boardList.jsp");		
	%>
	
	
</body>
</html>