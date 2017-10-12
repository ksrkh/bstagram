package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CreateBoardVO;
import com.kosta.bookstagram.model.LineBoardVO;
import com.kosta.bookstagram.model.MemberDAO;
import com.kosta.bookstagram.model.MemberVO;
import com.kosta.bookstagram.model.ReviewBoardVO;
import com.kosta.bookstagram.model.common.ListVO;
import com.kosta.bookstagram.model.common.PagingBean;

public class ViewMyBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//아이디, 게시판에 맞는 게시물 list
		int boardType=Integer.parseInt(request.getParameter("b_name"));
		String pno=request.getParameter("pageNo");
		PagingBean pagingBean=null;
		MemberVO mvo=null;
	
		//세션에 저장된 회원 id를 받아옴
		HttpSession session = request.getSession(false);
		if(session!=null)
			mvo=(MemberVO) session.getAttribute("mvo");
		
		int totalCount=MemberDAO.getInstance().totalCountByBoardNId(boardType, mvo.getId());
		if(pno==null){
			pagingBean=new PagingBean(totalCount);
		}else{
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pno));
		}
		
		//게시판type에 따라 list를 받아오는 다른 메서드 사용, ListVO 생성
		switch(boardType) {
		case 1:ArrayList<LineBoardVO> l_list=MemberDAO.getInstance().l_viewBoard(mvo.getId(), pagingBean);
			   ListVO<LineBoardVO> l_listVO=new ListVO<LineBoardVO>(l_list,pagingBean);
			   request.setAttribute("lvo", l_listVO);
			   request.setAttribute("url", "/board/list.jsp");	
			   break;
		case 2:ArrayList<ReviewBoardVO> r_list=MemberDAO.getInstance().r_viewBoard(mvo.getId(), pagingBean);
		   	   ListVO<ReviewBoardVO> r_listVO=new ListVO<ReviewBoardVO>(r_list,pagingBean);
		   	   request.setAttribute("lvo", r_listVO);
		   	   request.setAttribute("url", "/board/list.jsp");	
		       break;
		case 3:ArrayList<CreateBoardVO> c_list=MemberDAO.getInstance().c_viewBoard(mvo.getId(), pagingBean);
		   	   ListVO<CreateBoardVO> c_listVO=new ListVO<CreateBoardVO>(c_list,pagingBean);
		   	   request.setAttribute("lvo", c_listVO);
		   	   request.setAttribute("url", "/board/list.jsp");	
		       break;
		}
		
		//request.setAttribute("url", "/board/list.jsp");를 각자에 맞는 경로로 바꿔야 함
		
		return "/template/home.jsp";
		
	}

}
