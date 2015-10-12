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
		// ��ȡ�û�����URL
		String url = request.getRequestURL().toString();
		// ��ȡ�û������������·��
		String baseContextPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath()+"/";
		// ��ȡ�û������ģ��/������
		String reqestDeliverName = url.substring(baseContextPath.length());
		String moduleName = "";
		int n = reqestDeliverName.indexOf('/');
		// �û�ֱ�ӷ���ģ���Ŀ¼,�ƶϿ�����ģ��
		if(n == -1){
			String deliverName = "";
			// ��������ģ����
			deliverName = reqestDeliverName;
			// ��ʼ��������
			((BaseController) handler).init(moduleName,deliverName);			
		}else{
			// ��ȡģ����
			moduleName = reqestDeliverName.substring(0,n);
			// ��ȡ������
			String deliverName = reqestDeliverName.substring(n+1);
			// ��ʼ��������
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
