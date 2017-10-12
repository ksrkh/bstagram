package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.LineTendVO;
import com.kosta.bookstagram.model.MemberDAO;
import com.kosta.bookstagram.model.PasswordQuestionVO;

public class JoinFormController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<PasswordQuestionVO> questionlist = MemberDAO.getInstance().pwQuestionList();
		ArrayList<LineTendVO> tendlist = MemberDAO.getInstance().tendList();
		request.setAttribute("question", questionlist);
		request.setAttribute("tend", tendlist);
		return "ex-join.jsp";
	}

}
