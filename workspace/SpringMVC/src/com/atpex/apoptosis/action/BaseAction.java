package com.atpex.apoptosis.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * 组合单个servie业务，在Action实现类中提供业务集成方法
 * @author atpex
 *
 */
public abstract class BaseAction {

	protected ModelAndView model = new ModelAndView();
	
	public abstract void doAction(HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView getModel() {
		return model;
	}

	public void setModel(ModelAndView model) {
		this.model = model;
	}
	
	
}
