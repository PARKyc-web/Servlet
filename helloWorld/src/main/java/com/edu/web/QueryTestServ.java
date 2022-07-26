package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/queryTest")
public class QueryTestServ extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
				
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String intro = req.getParameter("introduction");
		
		out.print("<h3> 입력받은 값</h3>");
		out.print("<p>ID:" + id + "</p>");
		out.print("<p>비밀번호:" + pass + "</p>");
		
		out.print("취미: <ul>");
		for(int i=0; i<hobby.length; i++) {
			out.print("<li>"+hobby[i] +"</li>");
		}
		
		out.print("<p>성별:" + gender + "</p>");
		out.print("<p>종교:" + religion + "</p>");
		out.print("<p>자기소개:" + intro + "</p>");
		out.print("질의문자열" + req.getQueryString());
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
				
//		String id = req.getParameter("id");
//		String pass = req.getParameter("pass");
//		String[] hobby = req.getParameterValues("hobby");
//		String gender = req.getParameter("gender");
//		String religion = req.getParameter("religion");
//		String intro = req.getParameter("introduction");
//		
//		out.print("<h3> 입력받은 값</h3>");
//		out.print("<p>ID:" + id + "</p>");
//		out.print("<p>비밀번호:" + pass + "</p>");
//		
//		out.print("취미: <ul>");
//		for(int i=0; i<hobby.length; i++) {
//			out.print("<li>"+hobby[i] +"</li>");
//		}
//		
//		out.print("<p>성별:" + gender + "</p>");
//		out.print("<p>종교:" + religion + "</p>");
//		out.print("<p>자기소개:" + intro + "</p>");
		
		ServletInputStream sis = req.getInputStream(); // post: 입력스트림으로 들어옴
		int len = req.getContentLength(); // 데이터의 크기
		byte[] buffer = new byte[len];
		sis.readLine(buffer, 0, len);
		
		String queryString = new String(buffer);
		System.out.println("len : " +len);
		System.out.println("String : "+ queryString);
		out.print("질의문자열:" + queryString);
		
		sis.close();
		out.close();
	}
	
	
	
}
