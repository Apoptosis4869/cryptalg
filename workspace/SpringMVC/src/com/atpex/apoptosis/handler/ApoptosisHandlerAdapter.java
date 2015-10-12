package com.atpex.apoptosis.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.LastModified;

import com.atpex.apoptosis.controller.BaseController;

public class ApoptosisHandlerAdapter implements HandlerAdapter{

	@Override
	public boolean supports(Object handler) {
		return (handler instanceof BaseController);
	}

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 获取用户请求URL
		String url = request.getRequestURL().toString();
		// 获取用户请求的上下文路径
		String baseContextPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath()+"/";
		// 获取用户请求的模块/功能名
		String reqestDeliverName = url.substring(baseContextPath.length());
		String moduleName = "";
		int n = reqestDeliverName.indexOf('/');
		// 用户直接访问模块根目录,推断可能无模块
		if(n == -1){
			String deliverName = "";
			// 交换功能模块名
			deliverName = reqestDeliverName;
			// 初始化控制器
			((BaseController) handler).init(moduleName,deliverName);			
		}else{
			// 获取模块名
			moduleName = reqestDeliverName.substring(0,n);
			// 获取功能名
			String deliverName = reqestDeliverName.substring(n+1);
			// 初始化控制器
			((BaseController) handler).init(moduleName,deliverName);
		}
		
		return ((BaseController) handler).handleRequest(request, response);
	}

	@Override
	public long getLastModified(HttpServletRequest request, Object handler) {
		if (handler instanceof LastModified) {
			return ((LastModified) handler).getLastModified(request);
		}
		return -1L;
	}

}
