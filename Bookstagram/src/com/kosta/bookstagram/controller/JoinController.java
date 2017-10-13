package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.MemberDAO;
import com.kosta.bookstagram.model.MemberVO;

public class JoinController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		int age = Integer.parseInt(request.getParameter("age"));
		int question_code = Integer.parseInt(request.getParameter("pw_question"));
		String pw_ans = request.getParameter("pw_answer");
		String[] tend_code = request.getParameterValues("tend_code");
		MemberVO member = null;
		
		if(tend_code != null) {
			if(tend_code.length == 1)
				member = new MemberVO(id, pw, nick, age, Integer.parseInt(tend_code[0]), 0, 0, question_code, pw_ans);
			else if(tend_code.length == 2)
				member = new MemberVO(id, pw, nick, age, Integer.parseInt(tend_code[0]), Integer.parseInt(tend_code[1]), 0, question_code, pw_ans);
			else if(tend_code.length == 3)
				member = new MemberVO(id, pw, nick, age, Integer.parseInt(tend_code[0]), Integer.parseInt(tend_code[1]), Integer.parseInt(tend_code[2]), question_code, pw_ans);
		}else {
			member = new MemberVO(id, pw, nick, age, 0, 0, 0, question_code, pw_ans);
		}
		
		MemberDAO.getInstance().addMember(member);
		return "do.jsp";
	}
}
