package org.kosta.myboard.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myboard.model.MemberDAO;
import org.kosta.myboard.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST") == false) {
			throw new ServletException("로그인은 post 방식만 가능합니다");
		}
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO memberVO = MemberDAO.getInstance().login(id, password);
		
		if(memberVO == null) {
			return "redirect:member/login-fail.jsp";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("mvo", memberVO);
			return "redirect:ListController.do";
		}
	}

}
