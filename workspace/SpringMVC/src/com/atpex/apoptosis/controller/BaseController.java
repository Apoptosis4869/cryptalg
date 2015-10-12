package com.atpex.apoptosis.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.atpex.apoptosis.action.BaseAction;
import com.atpex.apoptosis.utils.CommonParam;

public abstract class BaseController implements Controller {

	protected Map<String,BaseAction> baseActionMap;
	protected BaseAction baseAction;
	private boolean NoAction;
	
	public void init(String moduleName,String deliverName) throws Exception{
		NoAction = false;
		// 分发到对应Action
		// 尝试无模块访问
		if("".equals(moduleName)){
			if(baseAction == null){
				NoAction = true;
			}else{
				baseAction.setResourcePath(deliverName);
			}
		}else{
			baseAction = baseActionMap.get(deliverName);
			
			if(baseAction == null){
				NoAction = true;
			}else{
				baseAction.setResourcePath(moduleName + "/" +deliverName);
			}
		}
		
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return dealWithRequest(request,response);
	}
	
	
	public ModelAndView packUpOutPutModelAndView(){
		// COMMON CONTENTS
		CommonParam.setAccessTime(baseAction.getModel());
		CommonParam.setGlobalMsg(baseAction.getModel());
		return baseAction.getModel();
	}
	
	public ModelAndView dealWithRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(NoAction){
			ModelAndView model404 = new ModelAndView();
			model404.setViewName("");
			return model404;
		}
		baseAction.doAction(request, response);
		return packUpOutPutModelAndView();
	}


	public BaseAction getBaseAction() {
		return baseAction;
	}


	public void setBaseAction(BaseAction baseAction) {
		this.baseAction = baseAction;
	}

	public Map<String, BaseAction> getBaseActionMap() {
		return baseActionMap;
	}

	public void setBaseActionMap(Map<String, BaseAction> baseActionMap) {
		this.baseActionMap = baseActionMap;
	}
	
	

}
