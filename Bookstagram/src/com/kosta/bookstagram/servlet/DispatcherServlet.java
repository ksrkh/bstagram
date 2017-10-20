package com.kosta.bookstagram.servlet;

import java.io.IOException;

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
		response.setContentType("text/html;charset=utf-8");
		handler(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		handler(request, response);
	}
	
	protected void handler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if(request.getRemoteAddr().equals("192.168.0.128") ||request.getRemoteAddr().equals("192.168.0.160") || request.getRemoteAddr().equals("192.168.0.118") || request.getRemoteAddr().equals("0:0:0:0:0:0:0:1")) {
				String command = request.getParameter("command");
				String url = HandlerMapping.getInstance().create(command).execute(request, response).trim();
				if (url.startsWith("redirect:")) {
					System.out.println("["+request.getRemoteAddr()+"]접속 URL :" + request.getAttribute("url"));
					response.sendRedirect(url.substring(9));
				}else {
					System.out.println("["+request.getRemoteAddr()+"]접속 URL :" + request.getAttribute("url"));
					request.getRequestDispatcher(url).forward(request, response);
				}
			}else {
				response.sendRedirect("notaccess.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("home.jsp");
		}
	}
}
