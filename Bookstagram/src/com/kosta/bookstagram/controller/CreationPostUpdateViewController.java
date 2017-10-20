package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BoardVO;
import com.kosta.bookstagram.model.CreateBoardDAO;
import com.kosta.bookstagram.model.CreateBoardVO;
import com.kosta.bookstagram.model.CreateCategoryVO;

public class CreationPostUpdateViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo=Integer.parseInt(request.getParameter("board_no"));
		ArrayList<BoardVO> bglist=CreateBoardDAO.getInstance().boardBackground(); 
		ArrayList<CreateCategoryVO> categoryList=CreateBoardDAO.getInstance().createCategory();
		CreateBoardVO cbvo= (CreateBoardVO) CreateBoardDAO.getInstance().selectBoard(boardNo);
		String content=cbvo.getCreate_content();
		cbvo.setCreate_content(content.replace("<br>","\r\n"));
		request.setAttribute("bglist", bglist);
		request.setAttribute("cbdvo", cbvo);
		request.setAttribute("cbno", boardNo);
		request.setAttribute("category", categoryList);
		request.setAttribute("url", "creation_updateview.jsp");
		return "home.jsp";
	}

}
