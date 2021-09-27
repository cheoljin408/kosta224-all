package step3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class TestListner
 *
 */
public class TestListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("contextDestroyed");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
        String security = event.getServletContext().getInitParameter("appSecurity");
    	System.out.println("contextInitialized security info:" + security);
    }
	
}
