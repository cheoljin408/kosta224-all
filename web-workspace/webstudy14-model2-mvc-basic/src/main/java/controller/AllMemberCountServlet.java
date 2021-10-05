package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

/**
 * Servlet implementation class AllMemberCountServlet
 */
@WebServlet("/AllMemberCountServlet")
public class AllMemberCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getServletName() + " 컨트롤러 실행");
		try {
			MemberDAO dao = new MemberDAO();
			int count = dao.getTotalCount();
			
			// Model과의 연동 결과를 request 객체에 정보를 할당해서 View가 사용할 수 있도록 한다
			request.setAttribute("count", count);
			// forward 방식으로 View로 이동한다
			request.getRequestDispatcher("allmembercount.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
