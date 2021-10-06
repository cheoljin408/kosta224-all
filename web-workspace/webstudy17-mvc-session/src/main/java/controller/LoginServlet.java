package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 	client가 전송한 아이디와 패스워드를 전달받아 java, abcd인지 확인해서
		 	
		 	일치하면
		 	session에 MemberVO 인증 객체를 할당하고
		 	login-ok.jsp로 redirect
		 	
		 	일치하지 않으면
		 	login-fail.jsp로 redirect 한다
		 */
		MemberVO vo = new MemberVO();
		String id = request.getParameter("memberId");
		String password = request.getParameter("memberPass");
		
		String path = null;
		if(id.equals("java") && password.equals("abcd")) {
			path = "login-ok.jsp";
			vo.setId(id);
			vo.setPassword(password);
			request.getSession().setAttribute("mvo", vo);
		}
		else {
			path = "login-fail.jsp";
		}
		response.sendRedirect(path);
	}

}
