package com.atpex.welcome.service;

import javax.servlet.http.HttpServletRequest;

import com.atpex.apoptosis.exceptions.BaseException;
import com.atpex.apoptosis.service.BaseService;
import com.atpex.apoptosis.utils.Constants;
import com.atpex.welcome.dto.UserInfoDTO;

public class UserInfoSessionService implements BaseService{

	@Override
	public Object doSingleService(Object... object) throws BaseException {
		UserInfoDTO userInfo = (UserInfoDTO)object[0];
		HttpServletRequest request = (HttpServletRequest)object[1];
		request.getSession().setAttribute(Constants.LOGIN_INFO, userInfo);
		return null;
	}

}
