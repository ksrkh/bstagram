package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;
import com.kosta.bookstagram.model.MemberVO;
import com.kosta.bookstagram.model.ReviewGenreVO;

public class ReviewWriteGerneController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ReviewGenreVO> rgvo = CmsDAO.getInstance().getGenreList();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		int member_tier = CmsDAO.getInstance().getMemberTier(member.getId());
		if(member_tier != 0) {
			request.setAttribute("genreList", rgvo);
			request.setAttribute("url", "book-review_write.jsp");
		}else {
			return "error.jsp";
		}
		return "home.jsp";
	}

}
