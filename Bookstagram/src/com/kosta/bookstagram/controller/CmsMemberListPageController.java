package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;

public class CmsMemberListPageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("member", CmsDAO.getInstance().getAllMemberList());
		request.setAttribute("url", "cms_member_list.jsp");
		return "home.jsp";
	}

}
