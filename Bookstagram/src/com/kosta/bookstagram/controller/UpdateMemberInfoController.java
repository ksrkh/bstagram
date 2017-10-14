package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.MemberDAO;
import com.kosta.bookstagram.model.MemberVO;

public class UpdateMemberInfoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		int age = Integer.parseInt(request.getParameter("age"));
		int pw_question = Integer.parseInt(request.getParameter("pw_question"));
		String pw_answer = request.getParameter("pw_answer");
		String[] tend_code = request.getParameterValues("tend_code");
		int tend_code1=0;
		int tend_code2=0;
		int tend_code3=0;
		if(tend_code.length>0)
			tend_code1=Integer.parseInt(tend_code[0]);
		if(tend_code.length>1)
			tend_code2=Integer.parseInt(tend_code[1]);
		if(tend_code.length>2)
			tend_code3=Integer.parseInt(tend_code[2]);
		MemberVO member= new MemberVO(id,pw,nick,age,tend_code1,tend_code2,tend_code3,pw_question,pw_answer);
		MemberDAO.getInstance().updateMember(member);
		
		//세션의 member를 갱신
		HttpSession session=request.getSession(false);
		if(session!=null)
			session.setAttribute("member", member);
		/*
		 * else
		 *  alert("세션이 만료되었습니다") 띄워주기
		 */
			
		return "do.jsp";
	}

}
