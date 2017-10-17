package com.kosta.bookstagram.controller;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CreateBoardDAO;
import com.kosta.bookstagram.model.CreateBoardVO;

public class CreationPostWriteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String id=request.getParameter("id");
		int bgNo=Integer.parseInt(request.getParameter("bgNo"));
		String create_title=request.getParameter("title");
		String create_content=request.getParameter("content");
		create_content=create_content.replace("", "<br>");
		int category=Integer.parseInt(request.getParameter("tend_code"));
		CreateBoardVO createVO = new CreateBoardVO(3, id, 1,bgNo, create_title, create_content, category);
		try {									  
			CreateBoardDAO.getInstance().insertBoard(createVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:DispatcherServlet?command=createboardlist";
	}
}
