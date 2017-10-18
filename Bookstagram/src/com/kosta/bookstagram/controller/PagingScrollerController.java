package com.kosta.bookstagram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.kosta.bookstagram.controller.listener.Controller;
import com.kosta.bookstagram.model.BoardVO;
import com.kosta.bookstagram.model.LineBoardDAO;
import com.kosta.bookstagram.model.LineBoardVO;
import com.kosta.bookstagram.model.MemberVO;
import com.kosta.bookstagram.model.common.ListVO;
import com.kosta.bookstagram.model.common.PagingBean;

public class PagingScrollerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int lineTotalCount=LineBoardDAO.getInstance().totalCountByBoard();
		String pno=request.getParameter("pageNo");
		PagingBean pagingBean=new PagingBean(lineTotalCount,1);
		String id=null;
	    HttpSession session=request.getSession(false);
	    System.out.println("현재페이지 : "+pno);
	    if(session==null||session.getAttribute("member")==null) {
	         System.out.println("로그인안됨");
	         id="-1";
	    }else {
	         id=((MemberVO) session.getAttribute("member")).getId();
	    }
	    
		if(pno==null){
			pagingBean=new PagingBean(lineTotalCount);
		}else{
			pagingBean=new PagingBean(lineTotalCount,Integer.parseInt(pno));
		}
		
		ArrayList<LineBoardVO> list=new ArrayList<LineBoardVO>();
	    ArrayList<BoardVO> blist=LineBoardDAO.getInstance().boardList(pagingBean);
	    
	    if(!(id.equals("-1"))) {
	         ArrayList<Integer> mlist=LineBoardDAO.getInstance().mySympathyList(pagingBean.getStartRowNumber(), pagingBean.getEndRowNumber(), id);
	         for(int i=0;i<blist.size();i++) {
	            for(int j=0;j<mlist.size();j++) {
	            if(blist.get(i).getBoard_no()==mlist.get(j))
	               blist.get(i).setMySympathy(1);
	            }
	         }
	    }
	    for(int i=0;i<blist.size();i++) {
	          list.add((LineBoardVO)blist.get(i));
	    }
		ListVO<LineBoardVO> listVO=new ListVO<LineBoardVO>(list,pagingBean);
		
		JSONObject ja=new JSONObject(listVO);
		request.setAttribute("responseBody", ja);
		return "AjaxView";
	}

}
