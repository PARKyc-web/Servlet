package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberSearchController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String id = req.getParameter("id");		
		
		if(id.isEmpty()) {			
			req.setAttribute("error", "ID를 입력해주세요!!");
			Utils.forward(req, resp, "memberView/memberSearch.jsp");
			return;
			
		}else {
			
			MemberVO vo = MemberService.getInstance().getMember(id);
			
			req.setAttribute("member", vo);
			Utils.forward(req, resp, "memberResult/memberSearchOutput.jsp");
		}
		
	}
	
}
