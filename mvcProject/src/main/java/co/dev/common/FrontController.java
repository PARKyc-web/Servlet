package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.controller.AddMemberAjaxController;
import co.dev.controller.MemberDeleteController;
import co.dev.controller.MemberInsertController;
import co.dev.controller.MemberJsonController;
import co.dev.controller.MemberListController;
import co.dev.controller.MemberSearchController;
import co.dev.controller.MemberUpdateController;
import co.dev.controller.RemoveMemberAjaxController;

public class FrontController extends HttpServlet{

	String enc;
	
	Map<String, Controller> mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		enc = config.getInitParameter("charset");		
		
		mappings = new HashMap<>();
		mappings.put("/memberInsert.do", new MemberInsertController());
		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberSearch.do", new MemberSearchController());
		mappings.put("/memberUpdate.do", new MemberUpdateController());
		mappings.put("/memberDelete.do", new MemberDeleteController());
		mappings.put("/memberJson.do", new MemberJsonController());
		
		// Ajax 입력
		mappings.put("/addMemberAjax.do", new AddMemberAjaxController());
		mappings.put("/removeMemberAjax.do", new RemoveMemberAjaxController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.setCharacterEncoding(enc);
		
		String uri = req.getRequestURI();	
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		System.out.println(path);
		
		Controller cntr = mappings.get(path);
		cntr.execute(req, resp);
		// 입력. -> View Page		
	}
	
	
	
}
