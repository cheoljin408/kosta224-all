package org.kosta.webstudy18.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy18.model.MemberDAO;
import org.kosta.webstudy18.model.MemberVO;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/UpdateMemberServlet")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// 로그인 상태가 아니면
		if(session == null || session.getAttribute("mvo") == null) {
			// index로 보낸다
			response.sendRedirect("index.jsp");
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPass = request.getParameter("memberPass");
		String memberName = request.getParameter("memberName");
		String memberAddress = request.getParameter("memberAddress");
		MemberVO vo = new MemberVO(memberId, memberPass, memberName, memberAddress);
		
		try {
			MemberDAO.getInstance().updateMember(vo);
			
			session.setAttribute("mvo", vo);
			
			response.sendRedirect("update-result.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
