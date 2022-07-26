package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.EmpDAO;
import com.edu.common.Employee;

@WebServlet("/emplist")
public class EmpListServlet extends HttpServlet {
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		
		List<Employee> list = dao.empList();
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter(); // 서블릿에서 사용하는 아웃 스트림을 만듬;
		String tag = "<thead>"
					+ "<tr>"
					+ "<th>#</th>"
					+ "<th>사원번호</th>"
					+ "<th>성</th>"
					+ "<th>이름</th>"
					+ "<th>이메일</th>"
					+ "<th>연봉</th>"
					+ "<th>입사일</th>"
					+ "<th>직무</th>"
					+ "</tr></thead>";	
		
		out.print("<table border='1'>");
		out.print(tag);
		out.print("<tbody>");
		int count =1;
		for(Employee i : list) {
			out.print("<tr>");
			out.print("<td>"+(count++)+"</td>"
					+ "<td>"+i.getEmployeeId()+"</td>"
					+ "<td>"+i.getLastName()+"</td>"
					+ "<td>"+i.getFisrtName()+"</td>"
					+ "<td>"+i.getEmail()+"</td>"
					+ "<td>"+i.getSalary()+"</td>"
					+ "<td>"+i.getHireDate()+"</td>"
					+ "<td>"+i.getJob()+"</td>"
					+ "</tr>");
		}
		out.print("</tbody></table>");		
	}
	
}
