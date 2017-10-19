package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BoardVO;
import com.kosta.bookstagram.model.CmsDAO;
import com.kosta.bookstagram.model.CreateBoardDAO;
import com.kosta.bookstagram.model.CreateCategoryVO;
import com.kosta.bookstagram.model.MemberVO;

public class CreationPostWriteViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<BoardVO> bglist=CreateBoardDAO.getInstance().boardBackground(); 
		ArrayList<CreateCategoryVO> categoryList=CreateBoardDAO.getInstance().createCategory();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		int member_tier = CmsDAO.getInstance().getMemberTier(member.getId());
		if(member_tier != 0) {
			request.setAttribute("bglist", bglist);
			request.setAttribute("category", categoryList);
			request.setAttribute("url", "creation_write.jsp");
		}else {
			return "error.jsp";
		}
		
		return "home.jsp";
	}

}
