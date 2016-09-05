package com.jetty.embedded_hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloWorldHandler extends AbstractHandler	 {

	public void handle(String target, Request request, HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws IOException, ServletException {
		
		/**
		 * NOTE: Target here will be path. e.g. for localhost:8080/json, target="/json"
		 * using target we can set different response based on target value.
		 */
		String name = servletRequest.getParameter("name");
		if(name == null) {
			name = "Guest";
		}
		
		if("/hello".equals(target)) {
			servletResponse.setContentType("text/html");
			servletResponse.getWriter().println("<h2>Hello " + name + " !!</h2>");
			servletResponse.setStatus(HttpServletResponse.SC_OK);
		}
		
		else if("/json".equals(target)) { 
			servletResponse.setContentType("application/json");
			servletResponse.getWriter().println("{\"message\":\"Hello "+name+" !!\"}");
			servletResponse.setStatus(HttpServletResponse.SC_OK);
		}else {
			servletResponse.getWriter().println("404 Not Found");
			servletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		request.setHandled(true);
	}
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		server.setHandler(new HelloWorldHandler());
		server.start();
		server.join();
	}
}
