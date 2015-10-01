package com.atpex.login.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.atpex.apoptosis.exceptions.BaseException;
import com.atpex.apoptosis.utils.CommonParam;
import com.atpex.exception.NoSuchUserInfoException;
import com.atpex.login.dao.UserInfoDAO;
import com.atpex.login.dto.UserInfoDTO;


public class UserInfoDAOImpl implements UserInfoDAO {

	private JdbcTemplate jdbcTemplate;

	@Override
	public UserInfoDTO queryUserInfo(String userid) throws BaseException {

		UserInfoDTO userInfo;
		List<Map<String, Object>> userList = jdbcTemplate.queryForList("SELECT * FROM USER_MASTER WHERE IDNO = ?",
				new Object[] { userid });
		if(userList == null || userList.size() == 0){
			throw new NoSuchUserInfoException(userid);
		}else {
			userInfo = (UserInfoDTO) CommonParam.convertMap(UserInfoDTO.class, userList.get(0));
		}
		return userInfo;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}
