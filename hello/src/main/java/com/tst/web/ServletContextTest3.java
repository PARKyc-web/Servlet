package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.SharedObject;

@WebServlet("/context3")
public class ServletContextTest3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext sc = this.getServletContext(); // ServletContext 호출
		
		SharedObject obj = new SharedObject();
		obj.setCount(100);
		obj.setStr("객체 공유 테스트");
		
		SharedObject obj2 = new SharedObject();
		obj2.setCount(200);
		obj2.setStr("객체 공유 테스트");
		
		sc.setAttribute("data", obj);
		sc.setAttribute("data2", obj2);
		
		resp.getWriter().print("ServletContext object Added");
	}
	
}
