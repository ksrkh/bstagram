package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.LineBoardDAO;
import com.kosta.bookstagram.model.LineTendVO;

public class TendListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<LineTendVO> ltList=LineBoardDAO.getInstance().tendList();
		request.setAttribute("ltList", ltList);
		request.setAttribute("url", "one-line-memo_write.jsp");
		return "home.jsp";
	}

}
