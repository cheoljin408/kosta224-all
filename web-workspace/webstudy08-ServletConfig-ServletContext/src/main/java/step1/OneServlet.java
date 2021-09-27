package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OneServlet
 */
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * ServletConfig와 ServletContext를 테스트하는 예제
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletConfig config = getServletConfig();
		// ServletConfig로부터 현 서블릿의 이름을 받아온다
		out.println("<h3>" + config.getServletName() + "</h3>");
		String springConfig = config.getInitParameter("contextConfigLocation");
		out.println("<h4>" + springConfig + " 스프링 설정파일을 로딩</h4>");
		
		// 웹 어플리케이션 공유 자원인 ServletContext 객체에 접근하여
		// 특정 정보를 할당해 본다
		ServletContext context = config.getServletContext();
		context.setAttribute("notice", "admin@kosta.or.kr");
		out.println("<a href=TwoServlet>TwoServlet에서 확인</a>");
		out.println("<hr>");
		out.println("ServletContext의 초기 파라미터:" + config.getServletContext().getInitParameter("appSecurity"));
		
		out.close();
	}

}
