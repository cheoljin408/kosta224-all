package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TwoServlet
 */
public class TwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * ServletContext로부터 OneServlet이 할당한 정보를 얻어와 보는 예제
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletConfig config = getServletConfig();
		// ServletConfig로부터 현 서블릿의 이름을 받아온다
		out.println("<h3>" + config.getServletName() + "</h3>");
		
		// ServletContext에 OneServlet이 할당한 정보를 getting
		String info = (String) config.getServletContext().getAttribute("notice");
		
		out.println("<h4>ServletContext로부터 OneServlet이 할당한 정보를 확인:");
		out.println(info + "</h4>");
		out.println("<a href=OneServlet>OneServlet에서 확인</a>");
		out.println("<hr>");
		out.println("ServletContext의 초기 파라미터:" + config.getServletContext().getInitParameter("appSecurity"));
		
		out.close();
	}

}
