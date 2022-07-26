<%@page import="java.util.List"%>
<%@page import="com.tst.common.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empResult.jsp</title>
</head>
<body>
	<table border ="1">
		<thead>
			<tr>
				<th>사원번호</th> <th>이름</th> <th>이메일</th> <th>급여</th>
			</tr>
		</thead>
		<tbody>		
			<%
				request.getParameter("first_name"); // request, out 은 jsp에 미리 생성되어있는 객체이다.
				List<Employee> list = (List<Employee>) request.getAttribute("data");
				for(Employee emp : list){
			%>		
				<tr>
					<td><%=emp.getEmployeeId() %></td> <td><%=emp.getFisrtName() %></td>
					<td><%=emp.getEmail() %></td> <td><%=emp.getSalary() %></td>
				</tr>
			<%
					//out.print("<br> 사원번호: " + emp.getEmployeeId() +", 이메일: " + emp.getEmail()
					//		 +", 연봉: " + emp.getSalary() + ", 직무: " + emp.getJob());
				}
			%>
		</tbody>
	</table>
</body>
</html>