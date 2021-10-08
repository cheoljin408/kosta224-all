package org.kosta.webstudy18.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy18.model.MemberDAO;
import org.kosta.webstudy18.model.MemberVO;

/**
 * Servlet implementation class FindMemberListByAddressServlet
 */
@WebServlet("/FindMemberListByAddressServlet")
public class FindMemberListByAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberAddress = request.getParameter("memberAddress");
		ArrayList<MemberVO> list;
		try {
			list = MemberDAO.getInstance().findMemberListByAddress(memberAddress);
			System.out.println(list.toString());
			
			String path = "findbyaddress-result.jsp";
			request.setAttribute("mlist", list);
			request.getRequestDispatcher(path).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
