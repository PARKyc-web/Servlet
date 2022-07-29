package co.dev.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Controller;
import co.dev.service.MemberService;

public class RemoveMemberAjaxController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String id = req.getParameter("id");		
		boolean isDeleted = MemberService.getInstance().removeMember(id);
		
		System.out.println(id);
		
		try {
			if(isDeleted) {
				resp.getWriter().print("{\"retCode\" : \"Success\"}");
			
			}else {
				resp.getWriter().print("{\"retCode\" : \"Fail\"}");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
