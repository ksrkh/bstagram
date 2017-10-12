package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.MemberDAO;
import com.kosta.bookstagram.model.MemberVO;

public class DupleNickCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("duple Nick : "+request.getParameter("nick"));
		MemberVO member = MemberDAO.getInstance().dupleByNick(request.getParameter("nick"));
		String result = null;
		
		if(member == null)
			result = "yes";
		else
			result = "no";
		
		request.setAttribute("responseBody", result);
		return "AjaxView";
	}

}
