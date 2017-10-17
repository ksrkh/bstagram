package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.LineBoardDAO;
import com.kosta.bookstagram.model.LineBoardVO;
import com.kosta.bookstagram.model.common.ListVO;
import com.kosta.bookstagram.model.common.PagingBean;

public class PagingScrollerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int lineTotalCount=LineBoardDAO.getInstance().totalCountByBoard();
		String pno=request.getParameter("pageNo");
		System.out.println(pno);
		System.out.println("페이징처리");
		PagingBean pagingBean=new PagingBean(lineTotalCount,1);
		if(pno==null){
			pagingBean=new PagingBean(lineTotalCount);
		}else{
			pagingBean=new PagingBean(lineTotalCount,Integer.parseInt(pno));
		}		
		ArrayList<LineBoardVO> list=new ArrayList<LineBoardVO>();
		for(int i=0;i<LineBoardDAO.getInstance().boardList(pagingBean).size();i++) {
			list.add((LineBoardVO)LineBoardDAO.getInstance().boardList(pagingBean).get(i));
		}
		ListVO<LineBoardVO> listVO=new ListVO<LineBoardVO>(list,pagingBean);
		
		JSONObject ja=new JSONObject(listVO);
		System.out.println(ja);
		request.setAttribute("responseBody", ja);
		return "AjaxView";
	}

}
