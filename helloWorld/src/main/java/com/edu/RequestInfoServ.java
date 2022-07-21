package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reqInfo")
public class RequestInfoServ extends HttpServlet{

	// init() -> request, response 객체 생성 -> service() 순서대로 실행이 됨.
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		// Network Info		
		PrintWriter out = resp.getWriter();
		out.print("<h3> Network Info </h3>");
		out.print("<p> Request Schema : " + req.getScheme() + "</p>");
		out.print("<p> Server name : " + req.getServerName() + "</p>");
		out.print("<p> Server Address : " + req.getLocalAddr() + "</p>");
		out.print("<p> Server Port : " + req.getServerPort() + "</p>");
		out.print("<p> Client Address : " + req.getRemoteAddr() + "</p>");
		out.print("<p> Client Host : " + req.getRemoteHost() + "</p>");
		out.print("<p> Client Port : " + req.getRemotePort() + "</p>");
		
		String str = "<hr><h3>URL INFO</h3>";		
		str += "<p>URL INFO : " + req.getRequestURI() + "</p>";
		str += "<p>Context Path : " + req.getContextPath()+ "</p>";
		str += "<p>Protocol Info : " + req.getProtocol() + "</p>";
		str += "<p>Servlet Path : " + req.getServletPath() + "</p>";
		
		
		str += "<hr><h3>요청헤더 정보</h3>";
		Enumeration<String> en = req.getHeaderNames();
		
		while(en.hasMoreElements()) {
			String elem = en.nextElement();
			String headValue = req.getHeader(elem);
			
			str +="<p>" + elem +", " + headValue + "</p>";
		}
		
		out.print(str);		
		out.close();		
	}
	
}
