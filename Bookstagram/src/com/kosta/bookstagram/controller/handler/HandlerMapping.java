package com.kosta.bookstagram.controller.handler;

import com.kosta.bookstagram.controller.CreationBoardListController;
import com.kosta.bookstagram.controller.CreationPostDeleteController;
import com.kosta.bookstagram.controller.CreationPostDetailController;
import com.kosta.bookstagram.controller.CreationPostWriteController;
import com.kosta.bookstagram.controller.listener.Controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {return instance;}
	
	public Controller create(String command) {
		Controller controller = null;
		if (command.equals("createpostwrite")) {
			controller = new CreationPostWriteController();
		}else if(command.equals("createboardlist")) {
			controller = new CreationBoardListController();
		}else if(command.equals("createpostdetail")) {
		controller = new CreationPostDetailController();
		}else if(command.equals("deletePosting")) {
		controller = new CreationPostDeleteController();
		}
		return controller;
	}
}

