package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @WebServlet("*.do)로 변경해
 * .do로 요청되는 모든 클라이언트의 요청을 처리
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		System.out.println(request.getContextPath());
		
		// contextPath와 .do를 제외한 컨트롤러명만 추출
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		System.out.println(uri.substring(contextPath.length()+1, uri.length()-3));
		
	}

}
