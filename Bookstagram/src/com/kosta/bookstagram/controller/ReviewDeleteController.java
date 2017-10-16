package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.ReviewBoardDAO;

public class ReviewDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo =Integer.parseInt(request.getParameter("board_no")) ;
		ReviewBoardDAO.getInstance().deleteBoard(boardNo);
		return "redirect:DispatcherServlet?command=reviewboardlist";
	}

}
