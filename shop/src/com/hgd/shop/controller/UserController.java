package com.hgd.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.shop.po.User;
import com.hgd.shop.service.UserService;
import com.hgd.shop.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserServlet")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService=new UserServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		//´¦ÀíµÇÂ½
		if (method!=null && method.equals("login")) {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			User user1=new User();
			user1.setUsername(username);
			user1.setPassword(password);
			User user=userService.login(user1);
			if (user!=null) {
				request.getSession().setAttribute("user",user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else if (method!=null && method.equals("logout")) {
			//ÍË³ö
			request.getSession().removeAttribute("user");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
