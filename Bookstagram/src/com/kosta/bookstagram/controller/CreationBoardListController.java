package com.kosta.bookstagram.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CreateBoardDAO;
import com.kosta.bookstagram.model.CreateBoardVO;

public class CreationBoardListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
		ArrayList<CreateBoardVO> list=new ArrayList<CreateBoardVO>();
			for(int i=0; i<CreateBoardDAO.getInstance().boardList().size();i++) {
				list.add((CreateBoardVO)CreateBoardDAO.getInstance().boardList().get(i));
			}	
			request.setAttribute("clist", list);
		return"layout/body/creation_list.jsp";
	}

}
