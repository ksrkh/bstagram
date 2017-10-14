package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;

public class CmsPwAnswerPageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setAttribute("answer", CmsDAO.getInstance().getTendList());
		request.setAttribute("url", "cms_pw_answer.jsp");
		return "home.jsp";
	}

}
