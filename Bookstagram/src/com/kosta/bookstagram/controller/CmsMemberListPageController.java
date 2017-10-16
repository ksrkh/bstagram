package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;
import com.kosta.bookstagram.model.MemberVO;
import com.kosta.bookstagram.model.common.ListVO;
import com.kosta.bookstagram.model.common.PagingBean;

public class CmsMemberListPageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int totalCount			=	CmsDAO.getInstance().totalCountByCmsMember();
		String cms_page_no		=	request.getParameter("pageNo");
		PagingBean pagingBean	=	null;
		ListVO<MemberVO> listVO	=	null;
		
		if(cms_page_no==null){
			pagingBean=new PagingBean(totalCount);
		}else{
			pagingBean=new PagingBean(totalCount,Integer.parseInt(cms_page_no));
		}
		
		listVO = new ListVO<MemberVO>(CmsDAO.getInstance().getAllMemberList(pagingBean), pagingBean);
		request.setAttribute("tend", CmsDAO.getInstance().getTendList());
		request.setAttribute("tier", CmsDAO.getInstance().getTierList());
		request.setAttribute("member", listVO);
		request.setAttribute("url", "cms_member_list.jsp");
		return "home.jsp";
	}
}
