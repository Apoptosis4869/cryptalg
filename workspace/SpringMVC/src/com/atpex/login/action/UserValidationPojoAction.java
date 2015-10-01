package com.atpex.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atpex.apoptosis.action.BaseAction;
import com.atpex.apoptosis.exceptions.BaseException;
import com.atpex.apoptosis.service.BaseService;

public class UserValidationPojoAction extends BaseAction {

	BaseService userValidateService;

	@Override
	public void doAction(HttpServletRequest request,
			HttpServletResponse response) {
		String validatedResult;
		try {
			validatedResult = (String) userValidateService.doSingleService(
					request.getParameter("userid"),
					request.getParameter("password"));
			model.addObject("result", validatedResult);
		} catch (BaseException e) {
			model.addObject("result", "FAIL");
			e.printStackTrace();
		}
	}

	public BaseService getUserValidateService() {
		return userValidateService;
	}

	public void setUserValidateService(BaseService userValidateService) {
		this.userValidateService = userValidateService;
	}

	
}
