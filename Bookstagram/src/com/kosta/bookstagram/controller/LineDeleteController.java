package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.LineBoardDAO;

public class LineDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		LineBoardDAO.getInstance().deleteBoard(boardNo);
		/*request.setAttribute("url", "DispatcherServlet?command=lineList");*/
		return "redirect:DispatcherServlet?command=lineList";
	}

}
