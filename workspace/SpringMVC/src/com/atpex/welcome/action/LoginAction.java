package com.atpex.welcome.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atpex.apoptosis.action.BaseAction;
import com.atpex.apoptosis.exceptions.BaseException;
import com.atpex.apoptosis.service.BaseService;
import com.atpex.apoptosis.utils.Constants;
import com.atpex.welcome.dto.UserInfoDTO;

public class LoginAction extends BaseAction {

	BaseService userValidateService;
	BaseService userInfoSessionService;

	@Override
	public void doAction(HttpServletRequest request,
			HttpServletResponse response) {
		UserInfoDTO userInfo;
		model.setViewName(Constants.JSON_VIEW);
		try {
			userInfo = (UserInfoDTO) userValidateService.doSingleService(
					request.getParameter("userid"),
					request.getParameter("password"));
			userInfoSessionService.doSingleService(userInfo,request);
			model.addObject("result", SUCCESS);
		} catch (BaseException e) {
			model.addObject("result", FAILED);
			e.printStackTrace();
		}
	}

	public BaseService getUserValidateService() {
		return userValidateService;
	}

	public void setUserValidateService(BaseService userValidateService) {
		this.userValidateService = userValidateService;
	}

	public BaseService getUserInfoSessionService() {
		return userInfoSessionService;
	}

	public void setUserInfoSessionService(BaseService userInfoSessionService) {
		this.userInfoSessionService = userInfoSessionService;
	}

	
}
