package com.atpex.login.service;


import com.atpex.apoptosis.exceptions.BaseException;
import com.atpex.apoptosis.service.BaseService;
import com.atpex.exception.UnmatchedUserPasswordException;
import com.atpex.login.dao.UserInfoDAO;
import com.atpex.login.dto.UserInfoDTO;

public class UserValidationService implements BaseService {

	UserInfoDAO userInfoDAO;
	

	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	@Override
	public Object doSingleService(Object... object) throws BaseException{
		UserInfoDTO userinfo;
		userinfo = userInfoDAO.queryUserInfo((String)object[0]);
		if(!((String)object[1]).equals(userinfo.getPassword())){
			throw new UnmatchedUserPasswordException((String)object[0]);
		}
		return "SUCCESS";
	}
	
	
}
