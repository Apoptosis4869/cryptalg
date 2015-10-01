package com.atpex.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.atpex.apoptosis.controller.BaseController;
import com.atpex.apoptosis.utils.Constants;


public class LoginController extends BaseController {

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		view_method = Constants.JSON_VIEW;
		return super.handleRequest(req, resp);

	}

}
