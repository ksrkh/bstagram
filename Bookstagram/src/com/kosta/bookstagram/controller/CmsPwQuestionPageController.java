package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;

public class CmsPwQuestionPageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("question", CmsDAO.getInstance().getPwQuestionList());
		request.setAttribute("url", "cms_pw_question.jsp");
		return "home.jsp";
	}

}
