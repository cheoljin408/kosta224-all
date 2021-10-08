package org.kosta.webstudy18.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy18.model.MemberDAO;
import org.kosta.webstudy18.model.MemberVO;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/RegisterMemberServlet")
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		String memberPass = request.getParameter("memberPass");
		String memberName = request.getParameter("memberName");
		String memberAddress = request.getParameter("memberAddress");
		MemberVO vo = new MemberVO(memberId, memberPass, memberName, memberAddress);
		
		try {
			MemberDAO.getInstance().register(vo);
			response.sendRedirect("register-result.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
