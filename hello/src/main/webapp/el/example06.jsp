<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Example 06 JSP</title>
</head>
<body>
	<c:import url="footer.jsp" var="footer"></c:import>
	<h3> 안녕하세요 </h3>
	스크립트릿: <%@ include file="footer.jsp" %>
	XML: <jsp:include page="footer.jsp"></jsp:include>
	JSTL: ${footer}
</body>
</html>