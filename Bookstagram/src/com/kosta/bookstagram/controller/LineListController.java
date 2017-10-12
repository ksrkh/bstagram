package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BoardVO;
import com.kosta.bookstagram.model.LineBoardDAO;

public class LineListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<BoardVO> list=LineBoardDAO.getInstance().boardList();
		request.setAttribute("lineList", list);
		request.setAttribute("url", "layout/body/one-line-memo_list.jsp");
		return "home.jsp";
	}
}
