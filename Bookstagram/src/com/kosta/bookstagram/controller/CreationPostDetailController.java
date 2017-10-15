package com.kosta.bookstagram.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CreateBoardDAO;
import com.kosta.bookstagram.model.CreateBoardVO;
import com.kosta.bookstagram.model.common.ReplyVO;

public class CreationPostDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
		String sboardNo=request.getParameter("board_no");
		int boardNo=Integer.parseInt(sboardNo);
		String id=request.getParameter("id");
		
		Cookie[] cookies=request.getCookies();
		Cookie c=null;
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				if((cookies[i].getName()).equals(sboardNo+id)){
					c=cookies[i];
				}
			}
			if(c==null) {
				Cookie newCookie=new Cookie(sboardNo+id,sboardNo);
				newCookie.setMaxAge(60*60*24);
				response.addCookie(newCookie);
				CreateBoardDAO.getInstance().hits(boardNo);
			}	
		}
		
		
		CreateBoardVO cbvo = (CreateBoardVO) CreateBoardDAO.getInstance().selectBoard(boardNo);
			ArrayList<ReplyVO> relist= CreateBoardDAO.getInstance().viewReply(boardNo);
			request.setAttribute("relist", relist);
			request.setAttribute("cbdvo", cbvo);
			request.setAttribute("url", "creation_content.jsp");
			
			System.out.println(cbvo.getHit());
			
			return "home.jsp";
	}
}
