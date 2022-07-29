package co.dev.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.dev.common.Controller;
import co.dev.common.Utils;
import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class AddMemberAjaxController implements Controller{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 회원정보 등록 -> JSON 값을 반환한다.
		
		resp.setContentType("text/json;charset=utf-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pwd);
		vo.setName(name);
		vo.setMail(mail);
		
		MemberService.getInstance().addMember(vo);
		
		// JSON 타입으로 반환
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(vo));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
