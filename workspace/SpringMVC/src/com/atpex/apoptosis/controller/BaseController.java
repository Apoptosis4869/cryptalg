package com.atpex.apoptosis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.atpex.apoptosis.action.BaseAction;
import com.atpex.apoptosis.utils.CommonParam;

public abstract class BaseController implements Controller {

	protected BaseAction baseAction;
	protected String view_method;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return dealWithRequest(request,response);
	}
	
	
	public ModelAndView packUpOutPutModelAndView(){
		// COMMON CONTENTS
		CommonParam.setAccessTime(baseAction.getModel());
		CommonParam.setGlobalMsg(baseAction.getModel());
		baseAction.getModel().setViewName(view_method);
		return baseAction.getModel();
	}
	
	public ModelAndView dealWithRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		baseAction.doAction(request, response);
		return packUpOutPutModelAndView();
	}


	public BaseAction getBaseAction() {
		return baseAction;
	}


	public void setBaseAction(BaseAction baseAction) {
		this.baseAction = baseAction;
	}
	
	

}
