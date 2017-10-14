package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BookVO;
import com.kosta.bookstagram.model.LineBoardDAO;
import com.kosta.bookstagram.model.LineBoardVO;

public class LineDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		LineBoardVO lvo=(LineBoardVO) LineBoardDAO.getInstance().selectBoard(boardNo);
		BookVO bvo=LineBoardDAO.getInstance().selectBook(boardNo);
		request.setAttribute("lineDVO", lvo);
		request.setAttribute("lineBook", bvo);
		request.setAttribute("url", "one-line-memo_content.jsp");
		return "home.jsp";
	}

}
