package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.MemberDAO;
import com.kosta.bookstagram.model.MemberVO;

public class LoginController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = null;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberVO member = MemberDAO.getInstance().checkMember(id, pw);
		
		if(member != null) {
			if(member.getTier() != 0) {
				System.out.println("Login Session Ok !");
				session = request.getSession();
				session.setAttribute("member", member);
				return "result:success";
			}
		}else {
			System.out.println("Login and Session Failed");
		}
			
		return "result:fail";
	}
}
