package com.kosta.bookstagram.controller.handler;

import com.kosta.bookstagram.controller.CmsBoardListPageController;
import com.kosta.bookstagram.controller.CmsCategoryPageController;
import com.kosta.bookstagram.controller.CmsGenrePageController;
import com.kosta.bookstagram.controller.CmsMemberListPageController;
import com.kosta.bookstagram.controller.CmsPwQuestionPageController;
import com.kosta.bookstagram.controller.CmsTendPageController;
import com.kosta.bookstagram.controller.CreationBoardListController;
import com.kosta.bookstagram.controller.CreationPostDeleteController;
import com.kosta.bookstagram.controller.CreationPostDetailController;
import com.kosta.bookstagram.controller.CreationPostUpdateController;
import com.kosta.bookstagram.controller.CreationPostUpdateViewController;
import com.kosta.bookstagram.controller.CreationPostWriteController;
import com.kosta.bookstagram.controller.CreationPostWriteViewController;
import com.kosta.bookstagram.controller.DeleteMemberInfoController;
import com.kosta.bookstagram.controller.DupleIdCheckController;
import com.kosta.bookstagram.controller.DupleNickCheckController;
import com.kosta.bookstagram.controller.JoinController;
import com.kosta.bookstagram.controller.JoinFormController;
import com.kosta.bookstagram.controller.LineDetailController;
import com.kosta.bookstagram.controller.LineListController;
import com.kosta.bookstagram.controller.LineWriteController;
import com.kosta.bookstagram.controller.LogOutController;
import com.kosta.bookstagram.controller.LoginController;
import com.kosta.bookstagram.controller.MyPageController;
import com.kosta.bookstagram.controller.ReviewBoardListController;
import com.kosta.bookstagram.controller.ReviewDetailController;
import com.kosta.bookstagram.controller.ReviewWriteController;
import com.kosta.bookstagram.controller.SearchBookController;
import com.kosta.bookstagram.controller.TendListController;
import com.kosta.bookstagram.controller.UpdateFormController;
import com.kosta.bookstagram.controller.UpdateMemberInfoController;
import com.kosta.bookstagram.controller.ViewMyBoardController;
import com.kosta.bookstagram.controller.listener.Controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		return instance;
	}

	public Controller create(String command) {
		Controller controller = null;
		
		if(command.equals("Login"))
			controller = new LoginController();
		else if(command.equals("Logout"))
			controller = new LogOutController();
		else if(command.equals("Join"))
			controller = new JoinController();
		else if(command.equals("JoinForm"))
			controller = new JoinFormController();
		else if (command.equals("createwriteview"))
			controller = new CreationPostWriteViewController();
		else if (command.equals("createpostwrite"))
			controller = new CreationPostWriteController();
		else if (command.equals("createboardlist"))
			controller = new CreationBoardListController();
		else if (command.equals("createpostdetail"))
			controller = new CreationPostDetailController();
		else if (command.equals("createpostingdelete"))
			controller = new CreationPostDeleteController();
		else if(command.equals("createupdateview"))
			controller = new CreationPostUpdateViewController();
		else if(command.equals("createpostupdate"))
			controller = new CreationPostUpdateController();
		else if(command.equals("viewMyBoard")) 
			controller = new ViewMyBoardController();
		else if(command.equals("dupleIdCheck"))
			controller = new DupleIdCheckController();
		else if(command.equals("dupleNickCheck"))
			controller = new DupleNickCheckController();
		else if(command.equals("lineList")) 
			controller=new LineListController();
		else if(command.equals("lineDetail")) 
			controller=new LineDetailController();
		else if(command.equals("reviewboardlist"))
			controller = new ReviewBoardListController();
		else if(command.equals("reviewdetail"))
			controller = new ReviewDetailController();
		else if(command.equals("myInfo"))
			controller = new MyPageController();
		else if(command.equals("deleteMemberInfo"))
			controller= new DeleteMemberInfoController();
		else if(command.equals("updateMemberInfo"))
			controller= new UpdateMemberInfoController();
		else if(command.equals("updateForm"))
			controller=new UpdateFormController();
		else if(command.equals("tendList"))
			controller = new TendListController();
		else if(command.equals("lineWrite"))
			controller = new LineWriteController();
		else if(command.equals("cmstendpage"))
			controller = new CmsTendPageController();
		else if(command.equals("cmsgenrepage"))
			controller = new CmsGenrePageController();
		else if(command.equals("cmscategorypege"))
			controller = new CmsCategoryPageController();
		else if(command.equals("cmspwquestionpage"))
			controller = new CmsPwQuestionPageController();
		else if(command.equals("cmsmemberlistpege"))
			controller = new CmsMemberListPageController();
		else if(command.equals("cmsboardlistpage"))
			controller = new CmsBoardListPageController();
		else if(command.equals("searchbook"))
			controller = new SearchBookController();
		else if(command.equals("reviewwrite"))
			controller = new ReviewWriteController();
		
		return controller;
	}
}
