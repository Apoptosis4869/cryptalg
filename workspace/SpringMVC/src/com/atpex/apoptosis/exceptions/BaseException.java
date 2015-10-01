package com.atpex.apoptosis.exceptions;

import com.atpex.apoptosis.utils.Constants;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String APOPTOSISEXCEPTION_MSG = "EXCEPTION OCCURED";
	
	public BaseException() {

		super(APOPTOSISEXCEPTION_MSG);

	}

	public BaseException(String msg) {
		super(msg);
		Constants.GLOBAL_MESSAGE = msg;

	}

	public BaseException(String msg, Throwable cause) {

		super(msg, cause);

	}

	public BaseException(Throwable cause) {

		super(cause);

	}
}
