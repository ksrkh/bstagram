package com.kosta.bookstagram.controller;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CreateBoardDAO;

public class CreationPostDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
		int boardNo=Integer.parseInt(request.getParameter("board_no"));
		CreateBoardDAO.getInstance().deleteBoard(boardNo);
		request.setAttribute("url", "creation_list.jsp");
		return "DispatcherServlet?command=createboardlist";
	}

}
