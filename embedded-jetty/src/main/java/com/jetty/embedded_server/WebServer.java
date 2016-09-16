package com.jetty.embedded_server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;

public class WebServer {
	private static final int PORT = 8080;
	private static final String RESOURCE_BASE = "src/main/resources";
	
	public static void main(String[] args) throws Exception{
		
		//instatiating Server object with port.
		Server server = new Server(PORT);
	
		//Setting welcome file and resource location
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setWelcomeFiles(new String[] {"html/index.html"});
		
		//By setting resource base, we are setting base path for resources (like js, css, images) 
		resourceHandler.setResourceBase(RESOURCE_BASE);
		
		// mapping "/hello" to the DemoServlet handler
		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(DemoServlet.class, "/hello");
		
		//creating the list of handlers that can be set in Server class instance.
		HandlerList handlerList = new HandlerList();
		handlerList.setHandlers(new Handler[] { resourceHandler, handler});
		
		//setting the Handlers
		server.setHandler(handlerList);
		
		server.start();
		server.join();
	}
}
