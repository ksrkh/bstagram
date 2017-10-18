package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;

public class LoginFailController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("["+request.getRemoteAddr()+"]"+"로그인 실패");
		request.setAttribute("url", "login_fail.jsp");
		return "home.jsp";
	}

}
