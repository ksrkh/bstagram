package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BoardVO;
import com.kosta.bookstagram.model.LineBoardDAO;
import com.kosta.bookstagram.model.common.PagingBean;

public class LineListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int totalCount=LineBoardDAO.getInstance().totalCountByBoard();
		String pno=request.getParameter("pageNo");
		PagingBean pagingBean=new PagingBean(totalCount,1);
		if(pno==null){
			pagingBean=new PagingBean(totalCount);
		}else{
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pno));
		}
		ArrayList<BoardVO> list=LineBoardDAO.getInstance().boardList(pagingBean);
		request.setAttribute("lineList", list);
		request.setAttribute("url", "one-line-memo_list.jsp");
		return "home.jsp";
	}
}
