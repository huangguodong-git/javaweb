package com.hgd.hotel.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.hotel.po.User;
import com.hgd.hotel.service.UserService;
import com.hgd.hotel.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AppRegisterController
 */
@WebServlet("/app/register.do")
public class AppRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService=new UserServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");			
		String loginname = request.getParameter("loginName");
		System.out.println("注册名："+loginname);
		//提交注册
		if (method!=null && method.equals("submitTable")) {
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String passWord = request.getParameter("passWord");
			//保存用户输入的信息到数据库
			User user = new User();
			user.setEmail(email);
			user.setLoginName(loginname);
			user.setPassword(passWord);
			user.setPhone(phone);
			userService.register(user);
			request.getRequestDispatcher("/WEB-INF/jsp/app/login.jsp").forward(request, response);
		}else if (method!=null && method.equals("ajaxLoginName")) {
			//检查用户名是否存在
			User user=userService.findByLoginName(loginname);
			if(user != null) {
				response.setCharacterEncoding("utf-8");
				//当前用户输入的登录名已经存在
				PrintWriter  printWriter = response.getWriter();
				printWriter.print("您输入的登录名已存在，请重新输入！");
				
				//刷新
				printWriter.flush();
				//关闭
				printWriter.close();
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/app/register.jsp").forward(request, response);
		}
	}

}
