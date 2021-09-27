package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
// 어노테이션 기반 서블릿 설정(xml 기반 서블릿 설정 webstudy07의 step1에 있다)
// 웹 어플리케이션 실행 시점에 미리 해당 서블릿을 초기화 하도록 web.xml의 load-on-startup 설정을
// 어노테이션 방식으로 설정해본다
@WebServlet(urlPatterns = "/LifeCycleServlet", loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * servlet 객체 생성은 1번 된다
     */
    public LifeCycleServlet() {
        super();
        System.out.println("LifeCycleServlet 객체 생성");
    }

    /**
     * init은 서블릿당 1번 실행
     */
    @Override
    public void init() throws ServletException {
    	System.out.println("init() 실행");
    }
	/**
	 * service는 클라이언트 호출 시 매번 실행
	 * web container가 service 메소드를 호출
	 * 상속받은 HttpServlet의 service 메소드가
	 * 클라이언트의 요청 방식에 따라 doGet() or doPost()를 실행
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("Annotation 설정 기반 서블릿 테스트" + getServletConfig().getServletName());
		System.out.println("service() -> doGet()");
		
		out.close();
	}
	
	/**
	 * destroy는 서비스 종료 직전(WAS 종료 직전)에 한번 호출
	 */
	@Override
	public void destroy() {
		System.out.println("destroy() 실행");
	}

}
