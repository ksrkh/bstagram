package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BoardVO;
import com.kosta.bookstagram.model.MemberDAO;
import com.kosta.bookstagram.model.MemberVO;
import com.kosta.bookstagram.model.common.ListVO;
import com.kosta.bookstagram.model.common.PagingBean;

public class ViewMyBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//아이디, 게시판에 맞는 게시물 list
		ArrayList<BoardVO> b_list=new ArrayList<BoardVO>();
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
		b_list=MemberDAO.getInstance().viewBoard(boardType,pagingBean);
		//ListVO에 담아서 view에 전달
		ListVO<BoardVO> listVO=new ListVO<BoardVO>(b_list,pagingBean);
		System.out.println(listVO);
		
		return null;
	}

}
