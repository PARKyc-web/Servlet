package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

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
//		mappings.put("/memberUpdate.do", new MemberUpdateController());
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
