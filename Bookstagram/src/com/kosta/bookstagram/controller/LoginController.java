package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.MemberDAO;
import com.kosta.bookstagram.model.MemberVO;

public class LoginController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberVO member = MemberDAO.getInstance().checkMember(id, pw);
		if(member != null) {
			System.out.println("Login Session Ok !");
			
			
		}else {
			System.out.println("Login and Session Failed");
			
			
		}
		return "home.jsp";
	}
}
