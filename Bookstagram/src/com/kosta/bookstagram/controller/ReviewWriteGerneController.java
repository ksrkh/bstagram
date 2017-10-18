package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;
import com.kosta.bookstagram.model.ReviewGenreVO;

public class ReviewWriteGerneController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ReviewGenreVO> rgvo = CmsDAO.getInstance().getGenreList();
		request.setAttribute("genreList", rgvo);
		request.setAttribute("url", "book-review_write.jsp");
		return "home.jsp";
	}

}
