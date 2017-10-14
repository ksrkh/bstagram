package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CreateBoardDAO;
import com.kosta.bookstagram.model.CreateCategoryVO;

public class CreationPostWriteViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<CreateCategoryVO> categoryList=CreateBoardDAO.getInstance().createCategory();
		request.setAttribute("category", categoryList);
		request.setAttribute("url", "creation_write.jsp");
		return "home.jsp";
	}

}
