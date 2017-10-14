package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;
import com.kosta.bookstagram.model.ReviewGenreVO;

public class CmsGenreUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("수정컨트롤러/"+request.getParameter("genre_code") + "/" + request.getParameter("genre_name"));
		CmsDAO.getInstance().updateGenre(new ReviewGenreVO(Integer.parseInt(request.getParameter("genre_code")), request.getParameter("genre_name")));
		return "DispatcherServlet?command=cmsgenrepage";
	}

}
