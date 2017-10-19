package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BookVO;
import com.kosta.bookstagram.model.LineBoardDAO;
import com.kosta.bookstagram.model.LineBoardVO;
import com.kosta.bookstagram.model.LineTendVO;

public class LineUpdateViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		LineBoardVO lvo=(LineBoardVO) LineBoardDAO.getInstance().selectBoard(boardNo);
		BookVO bvo=LineBoardDAO.getInstance().selectBook(boardNo);
		ArrayList<LineTendVO> ultList=LineBoardDAO.getInstance().tendList();	
		request.setAttribute("ultList", ultList);
		request.setAttribute("updateBvo", bvo);
		request.setAttribute("lvo", lvo);
		request.setAttribute("url", "one-line-memo_update.jsp");
		return "home.jsp";
	}

}
