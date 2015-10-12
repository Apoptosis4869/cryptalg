package com.atpex.welcome.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.atpex.apoptosis.exceptions.BaseException;
import com.atpex.apoptosis.utils.CommonParam;
import com.atpex.exception.NoSuchUserInfoException;
import com.atpex.welcome.dao.UserInfoDAO;
import com.atpex.welcome.dto.UserInfoDTO;


public class UserInfoDAO{

	private JdbcTemplate jdbcTemplate;

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
