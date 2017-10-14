package com.kosta.bookstagram.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CreateBoardDAO;
import com.kosta.bookstagram.model.CreateBoardVO;
import com.kosta.bookstagram.model.common.ListVO;
import com.kosta.bookstagram.model.common.PagingBean;

public class CreationBoardListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
		int totalCount=CreateBoardDAO.getInstance().totalCountByBoard();
		String pno=request.getParameter("pageNo");
		PagingBean pagingBean=new PagingBean(totalCount,1);
		if(pno==null){
			pagingBean=new PagingBean(totalCount);
		}else{
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pno));
		}
		ArrayList<CreateBoardVO> list=new ArrayList<CreateBoardVO>();
			for(int i=0; i<CreateBoardDAO.getInstance().boardList(pagingBean).size();i++) {
				list.add((CreateBoardVO)CreateBoardDAO.getInstance().boardList(pagingBean).get(i));
			}
		ListVO<CreateBoardVO> listVO=new ListVO<CreateBoardVO>(list,pagingBean);
		
		request.setAttribute("clist", listVO);
		request.setAttribute("url", "creation_list.jsp");
		return "home.jsp";
	}

}
