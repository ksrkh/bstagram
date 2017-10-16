package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;

public class CmsBoardDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int boardtype_no = Integer.parseInt(request.getParameter("boardtype_no"));
		CmsDAO.getInstance().cmsBoardDelete(boardtype_no, board_no);
		return "DispatcherServlet?command=cmsboardlistpage";
	}

}
