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
		String result = null;
		if(member != null) {
			if (member.getTier() == 0){
				//탈퇴회원
				result = "DispatcherServlet?command=LoginFail";
			}else {
				//로그인성공
				session = request.getSession();
				//세션시간 20분
				session.setMaxInactiveInterval(20*60);
				session.setAttribute("member", member);
				result = "DispatcherServlet?command=lineList";
				System.out.println("["+request.getRemoteAddr()+"]"+"로그인 성공");
			}
		}else {
			//로그인실패
			result = "DispatcherServlet?command=LoginFail";
		}
		
		return result;
	}
}
