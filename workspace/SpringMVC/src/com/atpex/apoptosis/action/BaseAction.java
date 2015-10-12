package com.atpex.apoptosis.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * ��ϵ���servieҵ����Actionʵ�������ṩҵ�񼯳ɷ���
 * @author atpex
 *
 */
public abstract class BaseAction {

	protected static final String SUCCESS = "SUCCESS";
	protected static final String FAILED = "FAILED";
	
	protected ModelAndView model = new ModelAndView();
	protected String resourcePath;
	
	public abstract void doAction(HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView getModel() {
		return model;
	}

	public void setModel(ModelAndView model) {
		this.model = model;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	
}
