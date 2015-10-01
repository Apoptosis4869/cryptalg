package com.atpex.error.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.atpex.apoptosis.controller.BaseController;
import com.atpex.apoptosis.utils.Constants;

public class ErrorController extends BaseController {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		view_method = "error" + Constants.JSP_VIEW;
		ModelAndView model = new ModelAndView();
		model.setViewName(view_method);
		return model;
	}
}