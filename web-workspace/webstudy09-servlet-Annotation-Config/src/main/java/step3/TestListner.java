package step3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TestListner
 *
 */
@WebListener
public class TestListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * 웹 어플리케이션 종료 직전 or ServletContext가 해제되기 직전에 호출
     */
    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("contextDestroyed");
    }

	/**
     * 웹 어플리케이션 시작 시점 or SerlvetContext가 생성되고 난 직후에 호출
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("contextInitialized");
    }
	
}
