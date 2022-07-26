package com.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.EmpDAO;

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
		boolean isTrue = false;
		
		if(req.getMethod().toUpperCase().equals("GET")) {			
			isTrue = dao.updateMember(name, pass, role);
					
		} else {
			isTrue = dao.insertMember(name, pass, role);
			
		}
		System.out.println(isTrue);
		if(isTrue) {
			resp.getWriter().print("....UPDATE Completed!");
			resp.getWriter().print("....INSERT Completed!");
		}else {
			resp.getWriter().print("....UPDATE Failed!");
			resp.getWriter().print("....INSERT Failed!");
		}
		
	}
	
	
}
