package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.ReviewBoardDAO;
import com.kosta.bookstagram.model.ReviewBoardVO;
import com.kosta.bookstagram.model.common.ListVO;
import com.kosta.bookstagram.model.common.PagingBean;

public class ReviewBoardListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int totalCount = ReviewBoardDAO.getInstance().totalCountByBoard();
		String pno = request.getParameter("pageNo");		
		int pageCountPerPageGroup = 5;
		int postCountPerPage = 10;
		PagingBean pagingBean=null;
		String content = null;
		//System.out.println("pano : "+pno);
		//추가**************************************************************************************************
		if(pno==null){
			pagingBean=new PagingBean(postCountPerPage,pageCountPerPageGroup,totalCount);
		}else{
			pagingBean=new PagingBean(Integer.parseInt(pno),postCountPerPage,pageCountPerPageGroup,totalCount);
		}
		//*****************************************************************************************************
		ArrayList<ReviewBoardVO> plist=new ArrayList<ReviewBoardVO>();
		for(int i=0; i<ReviewBoardDAO.getInstance().boardList(pagingBean).size();i++) {
			plist.add((ReviewBoardVO)ReviewBoardDAO.getInstance().boardList(pagingBean).get(i));
		}	
		for(int i=0;i<ReviewBoardDAO.getInstance().boardList(pagingBean).size();i++) {
			if(plist.get(i).getReview_content().length()>320) {
				content = plist.get(i).getReview_content().substring(0,300);
				plist.get(i).setReview_content(content+"...");	
			}else {
				content = plist.get(i).getReview_content();
				plist.get(i).setReview_content(content);
			}
			plist.get(i).setReview_content(content.replace("<br>","\r\n"));
		}
		ListVO<ReviewBoardVO> listVO=new ListVO<ReviewBoardVO>(plist,pagingBean);
		request.setAttribute("reviewlist", listVO);
		request.setAttribute("url", "book-review_list.jsp");
	return "home.jsp";
	}

	
	
	
	
}
