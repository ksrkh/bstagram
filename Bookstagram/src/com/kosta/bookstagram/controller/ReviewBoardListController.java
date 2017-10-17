package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.ReviewBoardDAO;
import com.kosta.bookstagram.model.ReviewBoardVO;
import com.kosta.bookstagram.model.common.PagingBean;

public class ReviewBoardListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ReviewBoardVO> plist=new ArrayList<ReviewBoardVO>();
		String content = null;
		PagingBean pagingBean=null;
		for(int i=0; i<ReviewBoardDAO.getInstance().boardList(pagingBean).size();i++) {
			plist.add((ReviewBoardVO)ReviewBoardDAO.getInstance().boardList(pagingBean).get(i));
		}	
		for(int i=0;i<ReviewBoardDAO.getInstance().boardList(pagingBean).size();i++) {
			if(plist.get(i).getReview_content().length()>320) {
				content = plist.get(i).getReview_content().substring(0,320);
				plist.get(i).setReview_content(content+"...");	
			}else {
				content = plist.get(i).getReview_content();
				plist.get(i).setReview_content(content);
			}
		}
		request.setAttribute("reviewlist", plist);
		request.setAttribute("url", "book-review_list.jsp");
	return "home.jsp";
	}

	
	
	
	
}
