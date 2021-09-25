package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	모든 서블릿과 jsp는 일반적으로 HttpServlet을 상속받는다
 */
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 5321989723167363912L;

	/*
	 	doGet() method: client 측에서 get 방식 요청시에 실행되는 메소드
	 	HttpServletRequest: client요청정보
	 	HttpServletResponse: client에게 응답하기 위한 정보
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); // 응답시 한글 처리를 위해 charset utf-8을 지정한다
		PrintWriter out = response.getWriter();
		
		out.println("<h3>BasicServlet doGet method</h3> 실행");
		
		out.close();
	}
	
	/*
	 	doPost() method: client 측에서 post방식 요청시에 실행되는 메소드
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h3>BasicServlet doPost method 실행</h3>");
		
		out.close();
	}
}
