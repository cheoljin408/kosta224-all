package step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {
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
		
		// 시간 정보
		String time = new Date().toString().replace(" ", "-");
		
		// 쿠키 생성
		Cookie cookie = new Cookie("time", time);
		
		// 쿠키 유효시간을 설정 (만약 설정하지 않으면 브라우저를 끄면 쿠키도 사라진다)
		cookie.setMaxAge(60);
		
		// 쿠키를 클라이언트 측으로 전송
		response.addCookie(cookie);
		
		out.println("cookie를 클라이언트 측으로 전달<br><br>");
		out.println("cookie에 저장한 time 정보:" + time);
		out.println("<br><br><a href=GetCookieServlet>GetCookieServlet에서 저장한 time cookie 정보 확인</a>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
