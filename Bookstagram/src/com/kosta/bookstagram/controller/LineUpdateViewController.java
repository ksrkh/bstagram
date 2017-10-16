package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BookVO;
import com.kosta.bookstagram.model.LineBoardDAO;
import com.kosta.bookstagram.model.LineBoardVO;
import com.kosta.bookstagram.model.LineTendVO;

public class LineUpdateViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("아아");
		//HttpSession session=request.getSession(false);
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		int tend_code=Integer.parseInt(request.getParameter("tend_code"));
		String line_content=request.getParameter("line_content");
		System.out.println(line_content);
		LineBoardVO dvo=(LineBoardVO) LineBoardDAO.getInstance().selectBoard(boardNo);
		BookVO bvo=LineBoardDAO.getInstance().selectBook(boardNo);
		ArrayList<LineTendVO> ultList=LineBoardDAO.getInstance().tendList();
		System.out.println(dvo.getBoard_no());
		LineBoardVO updateLvo=new LineBoardVO(dvo.getBoard_no(),dvo.getBoardtype_no(),dvo.getNick(),
				dvo.getBoard_regdate(),dvo.getHit(),dvo.getAuthority(),dvo.getBg_no(),line_content,tend_code,bvo.getBook_no());
		request.setAttribute("ultList", ultList);
		request.setAttribute("line_content", line_content);
		request.setAttribute("updateBvo", bvo);
		request.setAttribute("updateLvo", updateLvo);
		request.setAttribute("url", "one-line-memo_update.jsp");
		return "home.jsp";
	}

}
