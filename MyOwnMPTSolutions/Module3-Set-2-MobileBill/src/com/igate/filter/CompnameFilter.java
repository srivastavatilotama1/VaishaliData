package com.igate.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CompnameFilter implements Filter {

   
    public CompnameFilter() {
    	System.out.println("CompnameFilter Instantiated");
    }

	public void destroy() {
		System.out.println("CompnameFilter destroied");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("CompnameFilter Intialized");
	}

}
