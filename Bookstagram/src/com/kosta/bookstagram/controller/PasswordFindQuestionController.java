package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.MemberDAO;
import com.kosta.bookstagram.model.MemberVO;

public class PasswordFindQuestionController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		MemberVO mvo=MemberDAO.getInstance().idCheckForPWFind(id);
		String checkState=null;
		
		if(mvo==null)
			checkState="fail";
		else
			checkState=mvo.getId();
		
		request.setAttribute("responseBody",checkState);
		return "AjaxView";
	}

}
