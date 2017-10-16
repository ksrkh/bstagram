package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;

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
		System.out.println("id:" + id);
		System.out.println("pw:" + pw);
		System.out.println("age:" + age);
		System.out.println("tend1:" + tend1);
		System.out.println("tend2:" + tend2);
		System.out.println("tend3:" + tend3);
		System.out.println("tier:" + tier);
		
		//MemberDAO.getInstance().updateMember(new Member(id,pw,age,tend1,tend2,tend3,tier));
		return "DispatcherServlet?command=cmsmemberlistpege";
	}

}
