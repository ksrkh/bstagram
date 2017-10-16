package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;

public class CmsGenreDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CmsDAO.getInstance().deleteGenre(Integer.parseInt(request.getParameter("genre_code")));
		return "DispatcherServlet?command=cmsgenrepage";
	}

}
