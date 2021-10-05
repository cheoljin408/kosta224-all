package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

/**
 * Servlet implementation class RedirectTestServlet
 */
@WebServlet("/RedirectTestServlet")
public class RedirectTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Model과 연동
		MockDAO dao = new MockDAO();
		dao.register("상품정보");
		
		// redirect 방식으로 이동
		// redirect 방식은 응답시에 클라이언트에게 이동할 url을 지정해서 클라이언트가 view로 요청하게 하는 방식으로
		// 기존 request와 response는 유지되지 않는다
		// 아래 코드와 같이 정보를 공유할 수는 없다
		request.setAttribute("shareInfo", "검색정보");
		response.sendRedirect("redirect-result.jsp");
	}

}
