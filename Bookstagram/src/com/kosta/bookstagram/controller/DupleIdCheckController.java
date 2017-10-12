package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.MemberDAO;
import com.kosta.bookstagram.model.MemberVO;

public class DupleIdCheckController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("duple ID : "+request.getParameter("id"));
		MemberVO member = MemberDAO.getInstance().dupleById(request.getParameter("id"));
		if(member == null)
			return "result:yes";
		else
			return "result:no";
	}
}
