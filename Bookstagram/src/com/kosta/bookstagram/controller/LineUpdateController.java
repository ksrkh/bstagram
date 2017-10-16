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
		String id="";
		int book_no=0;
		LineBoardDAO.getInstance().updateBoard(new LineBoardVO(1,id,1,0,line_content,tend_code,book_no));
		System.out.println(boardNo);
		System.out.println(line_content);
		System.out.println(tend_code);
		
	/*	LineBoardDAO.getInstance().updateBoard(
				LineBoardDAO.getInstance().selectBoard(boardNo));*/
		
		
		/*int boardtype_no, String id, int authority, int bg_no,
		String line_content, int tend_code, int book_no*/
		
		return "redirect:DispatcherServlet?command=lineList";
	}

}
