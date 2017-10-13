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
			//로그인성공
			if(member.getTier() != 0) {
				session = request.getSession();
				session.setAttribute("member", member);
				result = "DispatcherServlet?command=lineList";
			}else {
				result = "ex-login_fail.jsp";
			}
		}else {
			//로그인실패
			result = "ex-login_fail.jsp";
		}
		
		return result;
	}
}
