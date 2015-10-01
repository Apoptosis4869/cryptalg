package com.atpex.apoptosis.service;

import com.atpex.apoptosis.exceptions.BaseException;

public interface BaseService {

	public Object doSingleService(Object... object) throws BaseException;
}
