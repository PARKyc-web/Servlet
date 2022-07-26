package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {	
	// 제일먼저 객채를 생성한다(생성자를 통해서)
	// 생성(생성자) --> ServletConfig 생성 --> init()  --> Service(req, resp) 실행 됨.
	
	// ServletConfig 가 하는일은 init()을 실행할대, 매개변수로 사용되며,
	// 기본 파라미터(Web.xml에 설정해둔 파라미터)를 읽는다.
	
	String id ="";
	String pass ="";
	
	public InitParamServlet() {
		System.out.println("InitParamServlet() 호출.");
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id");
		pass = config.getInitParameter("password");	
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<h3>서블릿 초기변수 설정</h3>");
		out.print("<p>ID : "+ id +"</p>");				// expect output: Guest
		out.print("<p>PASSWORD : "+ pass +"</p>");		// expect output: 1004;
		out.close();
	}
	
}
