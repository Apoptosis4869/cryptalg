package com.atpex.exception;

import com.atpex.apoptosis.exceptions.BaseException;

public class UnmatchedUserPasswordException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String UnmatchedUserPasswordException_MSG = "User password dismatched!";
	
	public UnmatchedUserPasswordException() {

		super(UnmatchedUserPasswordException_MSG);

	}
	
	public UnmatchedUserPasswordException(String userid) {

		super(UnmatchedUserPasswordException_MSG + "[CURRENT USERID:" + userid + "]");

	}


	public UnmatchedUserPasswordException(String msg, Throwable cause) {

		super(msg, cause);

	}

	public UnmatchedUserPasswordException(Throwable cause) {

		super(cause);

	}
}
