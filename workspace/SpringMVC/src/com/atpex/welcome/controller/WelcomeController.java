package com.atpex.welcome.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.atpex.apoptosis.controller.BaseController;
import com.atpex.apoptosis.utils.Constants;

public class WelcomeController extends BaseController {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		view_method = "index" + Constants.JSP_VIEW;
		ModelAndView model = new ModelAndView();
		model.setViewName(view_method);
		return model;
	}
}
