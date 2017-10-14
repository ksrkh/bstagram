package com.kosta.bookstagram.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.CmsDAO;
import com.kosta.bookstagram.model.CreateCategoryVO;

public class CmsCategoryUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("수정컨트롤러/"+request.getParameter("category_code") + "/" + request.getParameter("category_name"));
		CmsDAO.getInstance().updateCategory(new CreateCategoryVO(Integer.parseInt(request.getParameter("category_code")), request.getParameter("category_name")));
		return "DispatcherServlet?command=cmscategorypege";
	}

}
