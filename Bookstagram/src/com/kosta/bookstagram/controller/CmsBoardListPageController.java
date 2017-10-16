package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BoardVO;
import com.kosta.bookstagram.model.CmsDAO;
import com.kosta.bookstagram.model.common.ListVO;
import com.kosta.bookstagram.model.common.PagingBean;

public class CmsBoardListPageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int totalCount			=	CmsDAO.getInstance().totalCountByCmsBoard();
		String cms_page_no		=	request.getParameter("pageNo");
		PagingBean pagingBean	=	null;
		ListVO<BoardVO> listVO	=	null;
		
		if(cms_page_no==null){
			pagingBean=new PagingBean(totalCount);
		}else{
			pagingBean=new PagingBean(totalCount,Integer.parseInt(cms_page_no));
		}
		
		listVO = new ListVO<BoardVO>(CmsDAO.getInstance().getAllBoardList(pagingBean), pagingBean);
		request.setAttribute("board", listVO);
		request.setAttribute("url", "cms_board_list.jsp");
		
		return "home.jsp";
	}
}
