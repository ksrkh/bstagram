package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;

public class PasswordFindSolveController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("id", request.getParameter("id"));
		request.setAttribute("pw", request.getParameter("pw"));
		request.setAttribute("url", "passwordfindquestion2.jsp");
		return "home.jsp";
	}

}
