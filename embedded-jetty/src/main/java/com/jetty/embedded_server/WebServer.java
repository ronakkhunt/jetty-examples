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
		Server server = new Server(PORT);
	
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setWelcomeFiles(new String[] {"html/index.html"});
		resourceHandler.setResourceBase(RESOURCE_BASE);
		
		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(DemoServlet.class, "/hello");

		HandlerList handlerList = new HandlerList();
		handlerList.setHandlers(new Handler[] { resourceHandler, handler});
		
		server.setHandler(handlerList);
		server.start();
		server.join();
	}
}
