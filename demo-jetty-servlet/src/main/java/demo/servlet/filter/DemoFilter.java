package demo.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements Filter{
	
	FilterConfig filterConfig;
	
	public void init(FilterConfig paramFilterConfig) throws ServletException {
		filterConfig = paramFilterConfig;
		
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("Filtering HTTP requests");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {
		
	}

}
