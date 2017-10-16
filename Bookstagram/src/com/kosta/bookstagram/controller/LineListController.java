package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.LineBoardDAO;
import com.kosta.bookstagram.model.LineBoardVO;
import com.kosta.bookstagram.model.common.ListVO;
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
		ArrayList<LineBoardVO> list=new ArrayList<LineBoardVO>();
		for(int i=0;i<LineBoardDAO.getInstance().boardList(pagingBean).size();i++) {
			list.add((LineBoardVO)LineBoardDAO.getInstance().boardList(pagingBean).get(i));
		}
		ListVO<LineBoardVO> listVO=new ListVO<LineBoardVO>(list,pagingBean);
		request.setAttribute("lineList", listVO);
		request.setAttribute("url", "one-line-memo_list.jsp");
		return "home.jsp";
	}
}
