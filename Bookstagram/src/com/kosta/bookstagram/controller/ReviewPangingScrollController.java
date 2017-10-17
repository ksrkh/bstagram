package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.LineBoardDAO;
import com.kosta.bookstagram.model.LineBoardVO;
import com.kosta.bookstagram.model.ReviewBoardDAO;
import com.kosta.bookstagram.model.common.ListVO;
import com.kosta.bookstagram.model.common.PagingBean;

public class ReviewPangingScrollController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int reviewTotalCount = ReviewBoardDAO.getInstance().totalCountByBoard();
		String rpno = request.getParameter("reviewpageNo");
		System.out.println(rpno);
		System.out.println("페이징처리");
		PagingBean pagingBean=new PagingBean(reviewTotalCount,1);
		if(rpno==null){
			pagingBean=new PagingBean(reviewTotalCount);
		}else{
			pagingBean=new PagingBean(reviewTotalCount,Integer.parseInt(rpno));
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
