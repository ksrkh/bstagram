package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;
import com.kosta.bookstagram.model.PasswordQuestionVO;

public class CmsAddPwQuestionController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CmsDAO.getInstance().addFindPwQuestion(new PasswordQuestionVO(request.getParameter("passwordQw")));
		return "DispatcherServlet?command=cmspwquestionpage";
	}

}
