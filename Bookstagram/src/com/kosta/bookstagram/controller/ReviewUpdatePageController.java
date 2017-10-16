package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.ReviewBoardDAO;
import com.kosta.bookstagram.model.ReviewBoardVO;

public class ReviewUpdatePageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo=Integer.parseInt(request.getParameter("board_no"));
		ReviewBoardVO rbvo= (ReviewBoardVO) ReviewBoardDAO.getInstance().selectBoard(boardNo);
		request.setAttribute("review_update", rbvo);
		request.setAttribute("url", "book-review_update.jsp");
		return "home.jsp";
	}

}
