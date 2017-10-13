package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.ReviewBoardDAO;
import com.kosta.bookstagram.model.ReviewBoardVO;

public class ReviewDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo = Integer.parseInt(request.getParameter("review_no"));
		ReviewBoardVO rvo = (ReviewBoardVO) ReviewBoardDAO.getInstance().selectBoard(boardNo);		
		request.setAttribute("reviewdetail", rvo);
		return "ex-book_review_content.jsp";
	}

}
