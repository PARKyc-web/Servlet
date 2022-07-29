package co.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Controller;
import co.dev.common.Utils;
import co.dev.service.MemberService;

public class MemberDeleteController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("회원 삭제");
		
		String id = req.getParameter("id");		
		MemberService.getInstance().removeMember(id);
		
		req.setAttribute("id", id);
		
		Utils.forward(req, resp, "memberResult/memberDeleteOutput.jsp");
	}
	
}
