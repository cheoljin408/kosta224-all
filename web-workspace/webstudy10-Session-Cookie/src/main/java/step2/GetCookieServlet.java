package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieServlet
 */
@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
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
		// client request로부터 cookie 정보를 받아온다
		// System.out.println(request.getCookies()); // web application에서 저장한 쿠키가 하나 이상 존재하지 않으면 null이 반환
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			// cookies 배열을 for loop을 이용해 반복하면서 cookie의 name이 time인 cookie의 value를 화면에 제공
			boolean flag = false;
			for(int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().equals("time")) {
					out.println("client로부터 받아온 time cookie value:" + cookies[i].getValue());
					flag = true;
					break;
				}
			}
			if(flag == false) {
				out.println("time 쿠키가 존재하지 않습니다");
			}
		}
		else {
			out.println("쿠키가 존재하지 않습니다");
		}
		out.println("<br><br><a href=SetCookieServlet>SetCookieServlet으로 이동</a>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
