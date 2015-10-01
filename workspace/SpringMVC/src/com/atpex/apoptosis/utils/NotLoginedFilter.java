package com.atpex.apoptosis.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class NotLoginedFilter implements Filter {

	private static final String ERR_PAGE = "error";

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Object object = ((HttpServletRequest) request).getSession().getAttribute("HASLOGGED");
		String path = ((HttpServletRequest) request).getRequestURI();
		if(object == null && !path.endsWith("index") && !path.contains("/static/") && !path.contains("login")){
			request.getRequestDispatcher(ERR_PAGE).forward(request, response);
		}else{
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
