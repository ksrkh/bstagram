package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;
import com.kosta.bookstagram.model.ReviewBoardDAO;
import com.kosta.bookstagram.model.ReviewBoardVO;
import com.kosta.bookstagram.model.ReviewGenreVO;

public class ReviewUpdatePageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo=Integer.parseInt(request.getParameter("board_no"));
		ReviewBoardVO rbvo= (ReviewBoardVO) ReviewBoardDAO.getInstance().selectBoard(boardNo);
		ArrayList<ReviewGenreVO> rgvo = CmsDAO.getInstance().getGenreList();
		String content = rbvo.getReview_content();
		rbvo.setReview_content(content.replace("<br>","\r\n"));
		request.setAttribute("genreList", rgvo);
		request.setAttribute("review_update", rbvo);
		request.setAttribute("url", "book-review_update.jsp");
		return "home.jsp";
	}

}
