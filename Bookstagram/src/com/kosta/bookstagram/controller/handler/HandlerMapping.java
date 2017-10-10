package com.kosta.bookstagram.controller.handler;

import com.kosta.bookstagram.controller.listener.Controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {return instance;}
	
	public Controller create(String command) {
		Controller controller = null;
		if(command.equals("")) {
			
			
		}
		return controller;
	}
}

