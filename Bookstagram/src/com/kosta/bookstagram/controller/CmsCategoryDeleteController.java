package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;

public class CmsCategoryDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CmsDAO.getInstance().deleteCategory(Integer.parseInt(request.getParameter("category_code")));
		return "DispatcherServlet?command=cmscategorypege";
	}

}
