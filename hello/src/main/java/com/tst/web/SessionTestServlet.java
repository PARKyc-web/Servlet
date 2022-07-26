package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session = null;
		String param = req.getParameter("p");
		String msg = null;
		
		
		// 세션 생성, 변경, 삭제를 진행한다!
		if(param.equals("create")) {
			session = req.getSession(true); // 생선된 세션값이 있으면, Session 반환, 없으면 새로 생성하고 세션 반환
			
			if(session.isNew()) { // 세션이 언제 생성된건지 알아보는 메소드 이번에 생성되었으면 True
								  // 원래 생성되있던 세션이라면 False
				msg = "새로운 세션객체가 생성되었습니다.";
				
			}else {
				
				msg = "이전에 있던 세션객체가 반환되었습니다";				
			}
			
		}else if(param.equals("delete")) {			
			session =req.getSession(false); // 이 경우에, 세션값이 있으면 세션값을 주지만, 없으면 Null을 반환함
			
			if(session != null) {
				session.invalidate(); // 세션을 삭제하는 메소드
				msg = "세션을 삭제하였습니다.";
				
			}else {
				msg = "삭제할 세션객체가 없습니다.";
				
			}
			
		}else if(param.equals("add")) {
			session = req.getSession(); // default Value true
			
			session.setAttribute("msg", "메세지를 추가했습니다.");
			msg = "세션 객체에 속성을 추가함";
			
		}else if(param.equals("get")) {
			session =req.getSession(false); // 세션객체가 없으면 Null을 반환한다.
			
			if(session != null) {
				msg = (String)session.getAttribute("msg");
				
			}else {
				msg = "데이터를 추출할 세션이 없습니다.";
			}
			
		}else if(param.equals("remove")) {
			session = req.getSession(false);
			
			if(session != null) {
				session.removeAttribute("msg"); // 추가한 속성을 삭제하는 메소드
				msg = "세션의 객체를 삭제하였습니다.";
				
			}else {
				msg="속성을 제거할 세션이 없습니다.";
			}
		}
		resp.getWriter().print("처리결과: " + msg);		
	}
	

}
