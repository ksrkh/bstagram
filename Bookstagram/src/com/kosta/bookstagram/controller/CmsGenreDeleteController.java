package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;

public class CmsGenreDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("삭제컨트롤러/"+request.getParameter("genre_code"));
		return "DispatcherServlet?command=cmsgenrepage";
	}

}
