package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.LineBoardDAO;

public class SympathyServiceController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		int likeCount=LineBoardDAO.getInstance().likeService(id,board_no);
		request.setAttribute("responseBody",likeCount);
		return "AjaxView";
	}

}
