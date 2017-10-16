package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BookVO;
import com.kosta.bookstagram.model.LineBoardDAO;
import com.kosta.bookstagram.model.LineBoardVO;

public class LineWriteController implements Controller {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int tend_code=Integer.parseInt(request.getParameter("tend_code"));	
		String id=request.getParameter("member_id");
		String line_content=request.getParameter("line_content");
		String book_title=request.getParameter("book_title");
		String book_intro=request.getParameter("book_description");
		String book_author=request.getParameter("book_author");
		String book_publ=request.getParameter("book_publisher");
		String book_sdate=request.getParameter("book_pubdate");
		String book_img=request.getParameter("book_image");
		System.out.println(book_img);
		LineBoardVO boardVO=new LineBoardVO(1, id, 1, 0, line_content, tend_code,
				new BookVO(book_title,book_intro,book_author,book_publ,book_sdate,book_img));
		
		LineBoardDAO.getInstance().insertBoard(boardVO);
		
		return "redirect:DispatcherServlet?command=lineList";
	}

}
