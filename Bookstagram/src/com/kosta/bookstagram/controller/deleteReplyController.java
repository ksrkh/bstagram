package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;

import com.kosta.bookstagram.model.CreateBoardDAO;

public class deleteReplyController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int reply_no=Integer.parseInt(request.getParameter("reply_no"));
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		
		CreateBoardDAO.getInstance().removeReply(reply_no);
		
		return "DispatcherServlet?command=createpostdetail&board_no="+board_no;
	}

}
