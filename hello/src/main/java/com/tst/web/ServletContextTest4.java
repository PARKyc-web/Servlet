package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.SharedObject;

@WebServlet("/context4")
public class ServletContextTest4 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		
		ServletContext sc = this.getServletContext();	
		SharedObject obj = (SharedObject)sc.getAttribute("data");
		SharedObject obj2 = (SharedObject)sc.getAttribute("data2");
		
		resp.getWriter().print("Count: " + obj.getCount() + "Str: " + obj.getStr());
		resp.getWriter().print("Count: " + obj2.getCount() + "Str: " + obj2.getStr());
	}
	
}
