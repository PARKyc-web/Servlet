<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="delete.jsp" method="get">		
			
		<p>${param.bno}번을 삭제하시겠습니까??</p>
		<input type="hidden" name="bno" value="${param.bno}">
		<br><input type="submit" value="삭제"> <a href="boardList.jsp"> 뒤로가기 </a>
		
	</form>
	
	
</body>
</html>