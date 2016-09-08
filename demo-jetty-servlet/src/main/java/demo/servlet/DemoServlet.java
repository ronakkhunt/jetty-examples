package demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class DemoServlet extends HttpServlet {
	
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException{
		resp.getWriter().println("<h1>Hello World !</h1>");
	}
}
