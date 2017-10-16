package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.ReviewBoardDAO;
import com.kosta.bookstagram.model.ReviewBoardVO;

public class ReviewUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
		String title = request.getParameter("review_title");
		String content = request.getParameter("review_content");
		int genre = Integer.parseInt(request.getParameter("review_genre"));
		int bg_no = 1;
		ReviewBoardVO board = new ReviewBoardVO(boardNo, bg_no, title, content, genre);
		ReviewBoardDAO.getInstance().updateBoard(board);
		return "redirect:DispatcherServlet?command=reviewboardlist";
	}

}
