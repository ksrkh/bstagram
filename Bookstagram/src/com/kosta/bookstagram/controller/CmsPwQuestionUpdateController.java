package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;
import com.kosta.bookstagram.model.PasswordQuestionVO;

public class CmsPwQuestionUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CmsDAO.getInstance().updatePwFindQuestion(new PasswordQuestionVO(Integer.parseInt(request.getParameter("findPw_code")), request.getParameter("findPw_name")));
		return "DispatcherServlet?command=cmspwquestionpage";
	}

}
