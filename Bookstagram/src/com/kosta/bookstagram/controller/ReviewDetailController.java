package com.kosta.bookstagram.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CreateBoardDAO;
import com.kosta.bookstagram.model.ReviewBoardDAO;
import com.kosta.bookstagram.model.ReviewBoardVO;

public class ReviewDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sboardNo=request.getParameter("review_no");
		int boardNo = Integer.parseInt(request.getParameter("review_no"));
		String id=request.getParameter("id");
		String cookieNameId=null;
		
		if(id.contains("@")) 
			cookieNameId=id.substring(0, id.indexOf("@"))+id.substring(id.indexOf("@")+1, id.indexOf("."));
		else
			cookieNameId=id;
		
		Cookie[] cookies=request.getCookies();
		Cookie c=null;
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				if((cookies[i].getName()).equals(sboardNo+cookieNameId)){
					c=cookies[i];
				}
			}
			if(c==null) {
				Cookie newCookie=new Cookie(sboardNo+cookieNameId,sboardNo);
				newCookie.setMaxAge(60*60*24);
				response.addCookie(newCookie);
				CreateBoardDAO.getInstance().hits(boardNo);
			}	
		}
		
		ReviewBoardVO rvo = (ReviewBoardVO) ReviewBoardDAO.getInstance().selectBoard(boardNo);		
		request.setAttribute("reviewdetail", rvo);
		return "ex-book_review_content.jsp";
	}

}
