package com.hgd.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.hotel.po.Order;
import com.hgd.hotel.service.OrderService;
import com.hgd.hotel.service.impl.OrderServiceImpl;

@WebServlet("/sys/order.action")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService=new OrderServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if (method!=null && method.equals("list")) {
			List<Order> orders=orderService.findAll();
			request.setAttribute("orders",orders);
			request.getRequestDispatcher("/WEB-INF/jsp/sys/orderList.jsp").forward(request, response);
		}else if (method!=null && method.equals("update")) {
			String id=request.getParameter("id");
			String disabled=request.getParameter("disabled");
			Order order=orderService.findById(Integer.parseInt(id));
			order.setDisabled(Integer.parseInt(disabled));
			orderService.update(order);
			response.sendRedirect(getServletContext().getContextPath()+"/sys/order.action");
		}
	}

}
