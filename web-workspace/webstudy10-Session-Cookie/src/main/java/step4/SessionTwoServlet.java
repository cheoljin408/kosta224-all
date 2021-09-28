package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberVO;

/**
 * Servlet implementation class SessionTwoServlet
 */
@WebServlet("/SessionTwoServlet")
public class SessionTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>home</title>");
		out.println("</head>");
		out.println("</head>");
		out.println("<body>");
		String name = getServletName();
		out.println("<h3>" + name + "</h3>");
		// request.getSession(false): 기존 세션이 존재하면 기존 세션을 반환, 기존 세션이 존재하지 않으면 null을 반환
		HttpSession session = request.getSession(false);
		if(session != null) {
			out.println("session id:" + session.getId() + "<br>");
			// 회원 객체를 세션으로부터 리턴받아 회원의 name을 출력해본다
			// session의 getAttribute(name)를 이용한다
			MemberVO mvo = (MemberVO) session.getAttribute("mvo");
			System.out.println(mvo.toString());
			out.println("회원이름:" + mvo.getName());
		}
		else {
			out.println("세션이 존재하지 않습니다");
		}
		
		out.println("<br><br><a href=SessionOneServlet>SessionOneServlet으로 이동</a>");
		out.println("<br><br><a href=SessionThreeServlet>SessionThreeServlet으로 이동</a>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
