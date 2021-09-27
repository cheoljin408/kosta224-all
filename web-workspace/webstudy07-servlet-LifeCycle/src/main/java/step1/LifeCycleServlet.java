package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
        System.out.println("lifecycle 객체 생성");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("init() 실행");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h3>doGet method 실행</h3>");
		
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 실행");
	}

}
