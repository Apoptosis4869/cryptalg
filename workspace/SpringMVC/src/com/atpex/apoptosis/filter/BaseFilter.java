package com.atpex.apoptosis.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.atpex.apoptosis.utils.Constants;

public class BaseFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// ��ȡsession��Ϣ
		HttpSession sessionInfo = ((HttpServletRequest) req).getSession();
		// ���Ի�ȡ��¼��Ϣ
		Object loginInfo = sessionInfo.getAttribute(Constants.LOGIN_INFO);
		if(loginInfo == null){
			req.setAttribute("IS_LOGIN", false);
		}else {
			req.setAttribute("IS_LOGIN", true);
		}
		
		// ���Ի�ȡ��ǰ�û��ĵ�¼����
		Object loginClass = sessionInfo.getAttribute(Constants.LOGIN_CLASS);
		if(loginClass == null){
			req.setAttribute("IS_BANNED", false);
		}else {
			if(loginClass.equals(Constants.LOGIN_LEVEL.BANNED)){
				req.setAttribute("IS_BANNED", true);
			}else {
				req.setAttribute("IS_BANNED", false);
			}
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

	
}
