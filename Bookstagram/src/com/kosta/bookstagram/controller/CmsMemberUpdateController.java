package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;
import com.kosta.bookstagram.model.MemberVO;

public class CmsMemberUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		int tend1 = Integer.parseInt(request.getParameter("tend1"));
		int tend2 = Integer.parseInt(request.getParameter("tend2"));
		int tend3 = Integer.parseInt(request.getParameter("tend3"));
		int tier = Integer.parseInt(request.getParameter("tier"));
		CmsDAO.getInstance().cmsMemberUpdate(new MemberVO(id,pw,age,tend1,tend2,tend3,tier));
		return "DispatcherServlet?command=cmsmemberlistpege";
	}

}
