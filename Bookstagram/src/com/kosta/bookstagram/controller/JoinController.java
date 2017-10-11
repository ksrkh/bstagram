package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;

public class JoinController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		int age = Integer.parseInt(request.getParameter("age"));
		int pw_question = Integer.parseInt(request.getParameter("pw_question"));
		String pw_answer = request.getParameter("pw_answer");
		String[] tend_code = request.getParameterValues("tend_code");
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(nick);
		System.out.println(age);
		System.out.println(pw_question);
		System.out.println(pw_answer);
		for(int i=0 ; i<tend_code.length ; i ++) {
			System.out.println(tend_code[i]);
		}
		
		return "home.jsp";
	}
}
