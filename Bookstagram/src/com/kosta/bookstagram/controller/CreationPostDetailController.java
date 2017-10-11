package com.kosta.bookstagram.controller;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CreateBoardDAO;
import com.kosta.bookstagram.model.CreateBoardVO;

public class CreationPostDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
		int boardNo=Integer.parseInt(request.getParameter("board_no"));
			CreateBoardVO cbvo = (CreateBoardVO) CreateBoardDAO.getInstance().selectBoard(boardNo);
			request.setAttribute("cbdvo", cbvo);
		return "ex-creation_content.jsp";
	}
}
