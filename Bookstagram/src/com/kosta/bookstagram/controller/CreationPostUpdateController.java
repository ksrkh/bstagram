package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CreateBoardDAO;
import com.kosta.bookstagram.model.CreateBoardVO;

public class CreationPostUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		int bgNo=Integer.parseInt(request.getParameter("bgNo"));
		String create_title=request.getParameter("title");
		String create_content=request.getParameter("content");
		create_content=create_content.replace("\r\n","<br>");
		int category=Integer.parseInt(request.getParameter("tend_code"));
		CreateBoardVO createVO = new CreateBoardVO(boardNo,3, "kjhsc101218@naver.com", 1,bgNo, create_title, create_content, category);
		CreateBoardDAO.getInstance().updateBoard(createVO);
		return "redirect:DispatcherServlet?command=createboardlist";
	}

}
