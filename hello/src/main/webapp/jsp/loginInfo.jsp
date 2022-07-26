<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Info JSP</title>
</head>
<body>
	
	<%
		String msg = "test";
	%>
	
	<form action="login.jsp" method="post">
		ID: <input type="text" name ="id"><br>
		PW: <input type="password" name="passwd"><br>
		
		<input type="submit" value="로그인">
	</form>

	<script>
		alert("<%=msg%>");
	</script>

</body>
</html>