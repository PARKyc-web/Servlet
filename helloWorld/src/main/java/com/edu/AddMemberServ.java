package com.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addMember/*")
public class AddMemberServ extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자가 값을 입력
		// user_name=user2&user_pass=1234&role=1
		String name = req.getParameter("user_name");
		String pass = req.getParameter("user_pass");
		String role = req.getParameter("role");
		
		System.out.println(req.getQueryString());
		EmpDAO dao = new EmpDAO();
		if(req.getMethod().toUpperCase().equals("GET")) {			
			dao.updateMember(name, pass, role);
			resp.getWriter().print("....UPDATE Completed!");
		
		} else {
			dao.insertMember(name, pass, role);
			resp.getWriter().print("....INSERT Completed!");
		}
	
		
	}
	
	
}
