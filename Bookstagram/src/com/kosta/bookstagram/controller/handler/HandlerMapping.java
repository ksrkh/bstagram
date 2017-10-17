package com.kosta.bookstagram.controller.handler;

import com.kosta.bookstagram.controller.CmsAddCategoryController;
import com.kosta.bookstagram.controller.CmsAddGenreController;
import com.kosta.bookstagram.controller.CmsAddPwQuestionController;
import com.kosta.bookstagram.controller.CmsAddTendController;
import com.kosta.bookstagram.controller.CmsBoardDeleteController;
import com.kosta.bookstagram.controller.CmsBoardListPageController;
import com.kosta.bookstagram.controller.CmsCategoryDeleteController;
import com.kosta.bookstagram.controller.CmsCategoryPageController;
import com.kosta.bookstagram.controller.CmsCategoryUpdateController;
import com.kosta.bookstagram.controller.CmsGenreDeleteController;
import com.kosta.bookstagram.controller.CmsGenrePageController;
import com.kosta.bookstagram.controller.CmsGenreUpdateController;
import com.kosta.bookstagram.controller.CmsMemberListPageController;
import com.kosta.bookstagram.controller.CmsMemberUpdateController;
import com.kosta.bookstagram.controller.CmsPwQuestionPageController;
import com.kosta.bookstagram.controller.CmsPwQuestionUpdateController;
import com.kosta.bookstagram.controller.CmsTendDeleteController;
import com.kosta.bookstagram.controller.CmsTendPageController;
import com.kosta.bookstagram.controller.CmsTendUpdateController;
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
import com.kosta.bookstagram.controller.LineDeleteController;
import com.kosta.bookstagram.controller.LineDetailController;
import com.kosta.bookstagram.controller.LineListController;
import com.kosta.bookstagram.controller.LineUpdateController;
import com.kosta.bookstagram.controller.LineUpdateViewController;
import com.kosta.bookstagram.controller.LineWriteController;
import com.kosta.bookstagram.controller.LogOutController;
import com.kosta.bookstagram.controller.LoginController;
import com.kosta.bookstagram.controller.LoginFailController;
import com.kosta.bookstagram.controller.MyPageController;
import com.kosta.bookstagram.controller.PagingScrollerController;
import com.kosta.bookstagram.controller.PasswordFindFormController;
import com.kosta.bookstagram.controller.PasswordFindQuestionController;
import com.kosta.bookstagram.controller.PasswordFindSolveController;
import com.kosta.bookstagram.controller.ReplyRegisterController;
import com.kosta.bookstagram.controller.ReviewBoardListController;
import com.kosta.bookstagram.controller.ReviewDeleteController;
import com.kosta.bookstagram.controller.ReviewDetailController;
import com.kosta.bookstagram.controller.ReviewUpdateController;
import com.kosta.bookstagram.controller.ReviewUpdatePageController;
import com.kosta.bookstagram.controller.ReviewWriteController;
import com.kosta.bookstagram.controller.ReviewWriteGerneController;
import com.kosta.bookstagram.controller.SearchBookController;
import com.kosta.bookstagram.controller.SympathyServiceController;
import com.kosta.bookstagram.controller.TendListController;
import com.kosta.bookstagram.controller.UpdateFormController;
import com.kosta.bookstagram.controller.UpdateMemberInfoController;
import com.kosta.bookstagram.controller.ViewMyBoardController;
import com.kosta.bookstagram.controller.deleteReplyController;
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
		else if(command.equals("LoginFail"))
			controller = new LoginFailController();
		else if(command.equals("Logout"))
			controller = new LogOutController();
		else if(command.equals("Join"))
			controller = new JoinController();
		else if(command.equals("JoinForm"))
			controller = new JoinFormController();
		else if(command.equals("PasswordFindForm"))
			controller = new PasswordFindFormController();
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
		else if(command.equals("cmstendupdate"))
			controller=new CmsTendUpdateController();
		else if(command.equals("cmstenddelete"))
			controller=new CmsTendDeleteController();
		else if(command.equals("cmsgenreupdate"))
			controller=new CmsGenreUpdateController();
		else if(command.equals("cmsgenredelete"))
			controller=new CmsGenreDeleteController();
		else if(command.equals("cmscategoryupdate"))
			controller=new CmsCategoryUpdateController();
		else if(command.equals("cmscategorydelete"))
			controller=new CmsCategoryDeleteController();
		else if(command.equals("cmspwquestionupdate"))
			controller=new CmsPwQuestionUpdateController();
		else if(command.equals("cmsboarddelete"))
			controller = new CmsBoardDeleteController();
		else if(command.equals("cmsmemberudt"))
			controller = new CmsMemberUpdateController();
		else if(command.equals("searchbook"))
			controller = new SearchBookController();
		else if(command.equals("reviewwrite"))
			controller = new ReviewWriteController();
		else if(command.equals("replyRegister"))
			controller=new ReplyRegisterController();
		else if(command.equals("addcmstend"))
			controller=new CmsAddTendController();
		else if(command.equals("addcmsgenre"))
			controller=new CmsAddGenreController();
		else if(command.equals("addcmscategory"))
			controller=new CmsAddCategoryController();
		else if(command.equals("addcmspwquestion"))
			controller=new CmsAddPwQuestionController();
		else if(command.equals("deleteReply"))
			controller=new deleteReplyController();
		else if(command.equals("reviewdelete"))
			controller = new ReviewDeleteController(); 
		else if(command.equals("reviewupdate"))
			controller = new ReviewUpdateController();
		else if(command.equals("reviewupdatepage"))
			controller = new ReviewUpdatePageController();
		else if(command.equals("lineUpdateView"))
			controller = new LineUpdateViewController();
		else if(command.equals("lineDelete"))
			controller = new LineDeleteController();
		else if(command.equals("lineUpdate"))
			controller = new LineUpdateController();
		else if(command.equals("pangingScroll"))
			controller = new PagingScrollerController();
		else if(command.equals("sympathyService"))
			controller=new SympathyServiceController();
		else if(command.equals("reviewwritebutton"))
			controller = new ReviewWriteGerneController();
		else if(command.equals("passwordfind2"))
			controller = new PasswordFindQuestionController();
		else if(command.equals("passwordfind3"))
			controller = new PasswordFindSolveController();
			
		return controller;
	}
}
