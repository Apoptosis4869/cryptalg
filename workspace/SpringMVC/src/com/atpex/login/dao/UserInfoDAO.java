package com.atpex.login.dao;

import com.atpex.apoptosis.exceptions.BaseException;
import com.atpex.login.dto.UserInfoDTO;

public interface UserInfoDAO {

	public UserInfoDTO queryUserInfo(String userid) throws BaseException;
}
