package com.hgd.hotel.controller;

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

@WebServlet("/sys/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService=new UserServiceImpl();
	
	//ע��
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");			
		String loginname = request.getParameter("loginname");
		//�ύע��
		if (method!=null && method.equals("submitTable")) {
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String passWord = request.getParameter("passWord");
			//�����û��������Ϣ�����ݿ�
			User user = new User();
			user.setEmail(email);
			user.setLoginName(loginname);
			user.setPassword(passWord);
			user.setPhone(phone);
			userService.register(user);
			request.getRequestDispatcher("/WEB-INF/jsp/sys/login.jsp").forward(request, response);
		}else if (method!=null && method.equals("ajaxLoginName")) {
			//����û����Ƿ����
			User user=userService.findByLoginName(loginname);
			if(user != null) {
				response.setCharacterEncoding("utf-8");
				//��ǰ�û�����ĵ�¼���Ѿ�����
				PrintWriter  printWriter = response.getWriter();
				printWriter.print("������ĵ�¼���Ѵ��ڣ����������룡");
				
				//ˢ��
				printWriter.flush();
				//�ر�
				printWriter.close();
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/sys/register.jsp").forward(request, response);
		}
	}

}
