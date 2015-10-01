package com.atpex.exception;

import com.atpex.apoptosis.exceptions.BaseException;

public class NoSuchUserInfoException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String UnmatchedUserPasswordException_MSG = "the user be queried is not existed!";
	
	public NoSuchUserInfoException() {

		super(UnmatchedUserPasswordException_MSG);

	}
	
	public NoSuchUserInfoException(String userid) {

		super(UnmatchedUserPasswordException_MSG + "[CURRENT USERID:" + userid + "]");

	}


	public NoSuchUserInfoException(String msg, Throwable cause) {

		super(msg, cause);

	}

	public NoSuchUserInfoException(Throwable cause) {

		super(cause);

	}
}
