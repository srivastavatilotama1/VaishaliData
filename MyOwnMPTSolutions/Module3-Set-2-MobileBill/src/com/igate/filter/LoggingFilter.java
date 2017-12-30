package com.igate.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.Date;

public class LoggingFilter implements Filter {

	public LoggingFilter() {
		System.out.println("LoginFilter Instantatied");
	}

	public void destroy() {
		System.out.println("LoginFilter Destroied");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Login Filtered doFilter......................");
		String username = request.getParameter("uName");
		Logger logger = Logger.getLogger(LoggingFilter.class);
		PropertyConfigurator
				.configure("myprop.properties");
		System.out.println(".......................");

		logger.warn("Here is some user tried to login   " + username + "on "
				+ new Date());
		logger.error("Here is some user tried to login   " + username + "on "
				+ new Date());
		logger.fatal("Here is some user tried to login  " + username + "on "
				+ new Date());

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LoginFilter Initialized");
	}

}
