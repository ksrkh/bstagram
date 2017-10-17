package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.LineBoardDAO;


public class SearchBookController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String book_name	= request.getParameter("book_search");
		String bookInfo		= LineBoardDAO.getInstance().searchBook(book_name);
		request.setAttribute("responseBody",bookInfo);
		return "AjaxView";
	}
}
