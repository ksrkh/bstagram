package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;
import com.kosta.bookstagram.model.LineTendVO;

public class CmsTendUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("수정컨트롤러/"+request.getParameter("tend_code") + "/" + request.getParameter("tend_name"));
		CmsDAO.getInstance().updateTend(new LineTendVO(Integer.parseInt(request.getParameter("tend_code")), request.getParameter("tend_name")));
		return "DispatcherServlet?command=cmstendpage";
	}

}
