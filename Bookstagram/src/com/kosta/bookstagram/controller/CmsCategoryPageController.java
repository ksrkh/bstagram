package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;

public class CmsCategoryPageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("category", CmsDAO.getInstance().getCategoryList());
		request.setAttribute("url", "cms_category.jsp");
		return "home.jsp";
	}

}
