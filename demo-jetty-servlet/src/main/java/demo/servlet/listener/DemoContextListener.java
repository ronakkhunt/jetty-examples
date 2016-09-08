package demo.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DemoContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("Initializing servlet context");
		System.out.println("Path: "+servletContextEvent.getServletContext().getContextPath());
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("Initializing servlet context");
		System.out.println("Path: "+servletContextEvent.getServletContext().getContextPath());
	}

}
