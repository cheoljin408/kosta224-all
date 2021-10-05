package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

/**
 * Servlet implementation class FindMemberByIdServlet
 */
@WebServlet("/FindMemberByIdServlet")
public class FindMemberByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 	컨트롤러 로직
		 	1. 클라이언트가 전달한 아이디를 받아온다
		 	2. Model(MemberDAO)과 연동해서 결과를 반환받는다
		 	3. 반환받은 MemberVO가 null이면
		 	   findMemberById-fail.jsp로 이동시킨다(forward)
		 	4. 반환받는 MemberVO가 null이 아니면
		 	   request에 MemberVO를 할당한다.
		 	   findMemberById-ok.jsp로 이동시킨다(forward)
		 */
		try {
			MemberDAO dao = new MemberDAO();
			MemberVO vo = dao.findMemberById(request.getParameter("memberId"));
			String path = null;
			
			if(vo == null) {
				path = "findMemberById-fail.jsp";
			}
			else {
				request.setAttribute("member", vo);
				path = "findMemberById-ok.jsp";
			}
			request.getRequestDispatcher(path).forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
