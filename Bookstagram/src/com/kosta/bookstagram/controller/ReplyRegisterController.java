package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CreateBoardDAO;

public class ReplyRegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String content=request.getParameter("reply_content");
		int boardNO=Integer.parseInt(request.getParameter("board_no"));
		String id=request.getParameter("id");
		String board_type=request.getParameter("board_type");
		if(id==null)
			return "do.jsp";
		
		CreateBoardDAO.getInstance().registerReply(id, boardNO, content);
		if(board_type.equals("review"))
			return "redirect:DispatcherServlet?command=reviewdetail&review_no="+boardNO+"&id="+id;
		else
			return "redirect:DispatcherServlet?command=createpostdetail&board_no="+boardNO+"&id="+id;
	}

}
