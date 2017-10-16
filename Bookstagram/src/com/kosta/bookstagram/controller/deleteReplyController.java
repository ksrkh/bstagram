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
		String id=request.getParameter("id");
		int board_type=Integer.parseInt(request.getParameter("board_type"));
		CreateBoardDAO.getInstance().removeReply(reply_no);
		
		if(board_type==2)
			return "redirect:DispatcherServlet?command=reviewdetail&review_no="+board_no+"&id="+id;
		else
			return "redirect:DispatcherServlet?command=createpostdetail&board_no="+board_no+"&id="+id;
	}

}
