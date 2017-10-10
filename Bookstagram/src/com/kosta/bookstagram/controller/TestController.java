package com.kosta.bookstagram.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;

public class TestController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		return null;
	}
}
