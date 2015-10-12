package com.atpex.welcome.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atpex.apoptosis.action.BaseAction;
import com.atpex.apoptosis.utils.Constants;

public class HomeAction extends BaseAction{

	@Override
	public void doAction(HttpServletRequest request,
			HttpServletResponse response) {
		model.setViewName(resourcePath +Constants.JSP_VIEW);
	}

}
