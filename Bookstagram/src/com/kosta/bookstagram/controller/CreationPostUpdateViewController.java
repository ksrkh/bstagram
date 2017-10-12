package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CreateBoardDAO;
import com.kosta.bookstagram.model.CreateBoardVO;

public class CreationPostUpdateViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo=Integer.parseInt(request.getParameter("board_no"));
		CreateBoardVO cbvo= (CreateBoardVO) CreateBoardDAO.getInstance().selectBoard(boardNo);
		request.setAttribute("cbdvo", cbvo);
		return "ex-creation_updateview.jsp";
	}

}
