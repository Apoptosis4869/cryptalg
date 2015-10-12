package com.atpex.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.atpex.apoptosis.filter.BaseFilter;
import com.atpex.apoptosis.utils.Constants;

public class NotLoginedFilter extends BaseFilter {

	private static final String LOGIN_PAGE = "index";

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		super.doFilter(request, response, chain);
		// 获取session信息
		HttpSession sessionInfo = ((HttpServletRequest) request).getSession();
		String path = ((HttpServletRequest) request).getRequestURI();

		Object object = sessionInfo.getAttribute(Constants.LOGIN_INFO);

		if (object == null && !path.contains("/static/") && !path.endsWith("login")) {
			request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
			return;

		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
