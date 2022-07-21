package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third.do")
public class ThirdServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String value = req.getParameter("key");
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpInfo(value);
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		String tag = "<thead>"
					+ "<tr>"
					+ "<th>사원번호</th>"
					+ "<th>성</th>"
					+ "<th>이름</th>"
					+ "<th>이메일</th>"
					+ "<th>연봉</th></tr></thead>";		
		
		out.print("<table border='1'>");
		out.print(tag);
		out.print("<tbody>");
		for(Employee emp : list) {
			out.print("<tr>"
					+ "<td> " + emp.getEmployeeId() + "</td>"
					+ "<td> " + emp.getFisrtName() + "</td>"
					+ "<td> " + emp.getLastName() + "</td>"
					+ "<td> " + emp.getEmail() + "</td>"
					+ "<td> " + emp.getSalary() + "</td>"
					+ "</tr>");
		}
		out.print("</tbody>");
	}
	
}
