package com.kosta.bookstagram.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.handler.HandlerMapping;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DispatcherServlet() {super();}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handler(request, response);}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); handler(request, response);}
	
	protected void handler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			
			String command = request.getParameter("command");
			String url = HandlerMapping.getInstance().create(command).execute(request, response).trim();
			
			
			if(url.equals("fail")) {
				out.print("fail");
				out.close();
			}else if (url.startsWith("redirect:")) {
				response.sendRedirect(url.substring(9));
			}else {
				request.getRequestDispatcher(url).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
