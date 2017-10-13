package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BookVO;
import com.kosta.bookstagram.model.ReviewBoardDAO;
import com.kosta.bookstagram.model.ReviewBoardVO;

public class ReviewBoardListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ReviewBoardVO> plist=new ArrayList<ReviewBoardVO>();
		ArrayList<BookVO> blist = new ArrayList<BookVO>();
		for(int i=0; i<ReviewBoardDAO.getInstance().boardList().size();i++) {
			plist.add((ReviewBoardVO)ReviewBoardDAO.getInstance().boardList().get(i));
		}	
		/*for(int i=0;i< ;i++) {
			
		}*/
		request.setAttribute("booklist", blist);
		request.setAttribute("reviewlist", plist);
	return "layout/body/book-review_list.jsp";
	}

}
