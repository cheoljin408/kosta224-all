package org.kosta.webstudy20.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * step6에서는 컨트롤러명 .do 스타일로 요청을 처리
 * url-pattern 설정을 *.do로 명시
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 요청 uri를 통해 컨트롤러 명을 추출(command)
			// String command = request.getParameter("command");
			String uri = request.getRequestURI();
			String contextPath = request.getContextPath();
			String command = uri.substring(contextPath.length()+1, uri.length()-3);
			System.out.println(command);
			
			Controller controller = HandlerMapping.getInstance().create(command);
			
			// 개별 컨트롤러 객체 생성 로직
			String path = controller.execute(request, response);
			if(path.startsWith("redirect")) {
				response.sendRedirect(path.substring(9));
			}
			else {
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatch(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doDispatch(request, response);
	}

}
