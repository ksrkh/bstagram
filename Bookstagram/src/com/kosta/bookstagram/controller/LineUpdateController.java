package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.LineBoardDAO;
import com.kosta.bookstagram.model.LineBoardVO;

public class LineUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		String line_content=request.getParameter("line_content");
		int tend_code=Integer.parseInt(request.getParameter("tend_code"));
		LineBoardDAO.getInstance().updateBoard(new LineBoardVO(boardNo,0,line_content,tend_code));
		return "redirect:DispatcherServlet?command=lineList";
	}

}
