package com.hgd.hotel.sys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.hotel.dto.UserDto;
import com.hgd.hotel.po.User;
import com.hgd.hotel.service.UserService;
import com.hgd.hotel.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/sys/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService=new UserServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String loginName=request.getParameter("loginname");
		String password=request.getParameter("password");
		UserDto userDto=new UserDto();
		userDto.setLoginName(loginName);
		userDto.setPassword(password);
		//µÇÂ½
		User user=userService.login(userDto);
		if (user==null) {
			request.getRequestDispatcher("/WEB-INF/jsp/sys/login.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("user",user);
			response.sendRedirect(getServletContext().getContextPath()+"/sys/index.action");
		}
	}

}
