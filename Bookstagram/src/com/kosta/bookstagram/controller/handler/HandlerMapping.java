package com.kosta.bookstagram.controller.handler;

import com.kosta.bookstagram.controller.CreationBoardListController;
import com.kosta.bookstagram.controller.CreationPostDeleteController;
import com.kosta.bookstagram.controller.CreationPostDetailController;
import com.kosta.bookstagram.controller.CreationPostUpdateController;
import com.kosta.bookstagram.controller.CreationPostUpdateViewController;
import com.kosta.bookstagram.controller.CreationPostWriteController;
import com.kosta.bookstagram.controller.DupleIdCheckController;
import com.kosta.bookstagram.controller.DupleNickCheckController;
import com.kosta.bookstagram.controller.JoinController;
import com.kosta.bookstagram.controller.JoinFormController;
import com.kosta.bookstagram.controller.LineDetailController;
import com.kosta.bookstagram.controller.LineListController;
import com.kosta.bookstagram.controller.LogOutController;
import com.kosta.bookstagram.controller.LoginController;
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
		
		return controller;
	}
}
