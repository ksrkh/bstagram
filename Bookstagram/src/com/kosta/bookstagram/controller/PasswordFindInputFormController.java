package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.MemberDAO;
import com.kosta.bookstagram.model.MemberVO;
import com.kosta.bookstagram.model.PasswordQuestionVO;

public class PasswordFindInputFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		MemberVO mvo=MemberDAO.getInstance().idCheckForPWFind(id);
		ArrayList<PasswordQuestionVO> questionlist = MemberDAO.getInstance().pwQuestionList();
	
		//System.out.println(mvo.getId()+" "+mvo.getQuestion_code()+" "+mvo.getPw_ans());
		
		request.setAttribute("question", questionlist);
		request.setAttribute("mvo", mvo);
		request.setAttribute("url", "passwordfindquestion.jsp");
		
		return "home.jsp";
	}

}
