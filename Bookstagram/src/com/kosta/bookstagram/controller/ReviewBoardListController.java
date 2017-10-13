package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.ReviewBoardDAO;
import com.kosta.bookstagram.model.ReviewBoardVO;

public class ReviewBoardListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ReviewBoardVO> plist=new ArrayList<ReviewBoardVO>();
		String content = null;
		for(int i=0; i<ReviewBoardDAO.getInstance().boardList().size();i++) {
			plist.add((ReviewBoardVO)ReviewBoardDAO.getInstance().boardList().get(i));
		}	
		for(int i=0;i<ReviewBoardDAO.getInstance().boardList().size();i++) {
			content = plist.get(i).getReview_content().substring(0,320);
			plist.get(i).setReview_content(content+"...");
		}
		request.setAttribute("reviewlist", plist);
	return "layout/body/book-review_list.jsp";
	}

}
