package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BookVO;
import com.kosta.bookstagram.model.ReviewBoardDAO;
import com.kosta.bookstagram.model.ReviewBoardVO;

public class ReviewWriteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		int genre = Integer.parseInt(request.getParameter("review_genre"));
		String title = request.getParameter("review_title");
		String content = request.getParameter("review_content");
		String book_img = request.getParameter("review_book_img");
		String book_auth = request.getParameter("review_author");
		String book_publ = request.getParameter("review_publ");
		String book_title = request.getParameter("review_book_title");
		String book_intro = request.getParameter("review_book_intro");
		String book_sdate = request.getParameter("review_sdate");
		//String book_cate = request.getParameter("review_book_cate");
		int bg_no = 1;//Integer.parseInt(request.getParameter(""));
		ReviewBoardVO board = new ReviewBoardVO(2,id,1,bg_no,title,content,0,genre,new BookVO(book_title,book_intro,book_auth,book_publ,book_sdate,book_img));
		ReviewBoardDAO.getInstance().insertBoard(board);
		return "redirect:DispatcherServlet?command=reviewboardlist";
	}

}
