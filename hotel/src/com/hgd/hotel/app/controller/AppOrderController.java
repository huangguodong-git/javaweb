package com.hgd.hotel.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.hotel.po.DinnerTable;
import com.hgd.hotel.po.Food;
import com.hgd.hotel.po.Order;
import com.hgd.hotel.po.OrderDetail;
import com.hgd.hotel.service.DinnerTableService;
import com.hgd.hotel.service.FoodService;
import com.hgd.hotel.service.OrderDetailService;
import com.hgd.hotel.service.OrderService;
import com.hgd.hotel.service.impl.DinnerTableServiceImpl;
import com.hgd.hotel.service.impl.FoodServiceImpl;
import com.hgd.hotel.service.impl.OrderDetailServiceImpl;
import com.hgd.hotel.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class AppOrderController
 */
@WebServlet("/app/order.action")
public class AppOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DinnerTableService dinnerTableService=new DinnerTableServiceImpl();
	
	private OrderService orderService=new OrderServiceImpl();
	
	private FoodService foodService=new FoodServiceImpl();
	
	private OrderDetailService orderDetailService=new OrderDetailServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//下订单
		String method=request.getParameter("method");
		String dinnerTableId=request.getParameter("dinnerTableId");
		String total=request.getParameter("total");
		//获取购物车
		Map<Integer,Integer> shopCar=(Map<Integer, Integer>) request.getSession().getAttribute(dinnerTableId);
		DinnerTable dinnerTable=null;
		if (dinnerTableId!=null) {
			dinnerTable=dinnerTableService.findByDinnerTableId(Integer.parseInt(dinnerTableId));
			request.setAttribute("dinnerTable",dinnerTable);
		}
		if (method!=null && method.equals("order")) {
			Order order=new Order();
			order.setOrderCode(UUID.randomUUID().toString());
			order.setDinnerTable(dinnerTable);
			order.setOrderStatus(0);
			order.setTableId(Integer.parseInt(dinnerTableId));
			order.setTotalPrice(Double.parseDouble(total));
			//保存订单
			orderService.save(order);
			System.out.println("id==================>"+order.getId());
			List<OrderDetail> orderDetails = new ArrayList<>();
			Set<Integer> foodIds=shopCar.keySet();
			for (Integer foodId : foodIds) {
				//保存订单详情
				OrderDetail orderDetail=new OrderDetail();
				orderDetail.setOrderId(order.getId());
				orderDetail.setFoodId(foodId);
				Food food=foodService.findById(foodId);
				orderDetail.setFood(food);
				orderDetail.setBuyNum(shopCar.get(foodId));
				orderDetail.setDiscount(food.getDiscount());
				orderDetail.setDisabled(0);
				orderDetailService.save(orderDetail);
			}
			//展示订单
			List<Order> orders=orderService.findAll();
			request.setAttribute("orders",orders);
			request.getRequestDispatcher("/WEB-INF/jsp/app/orderItem.jsp").forward(request, response);
		}else if (method!=null && method.equals("pay")) {
			//付款 1为付款
			String orderId=request.getParameter("orderId");
			Order order=orderService.findById(Integer.parseInt(orderId));
			order.setOrderStatus(1);
			orderService.update(order);
			response.sendRedirect(getServletContext().getContextPath()+"/app/index.do");
		}else if (method!=null && method.equals("delete")) {
			//取消付款 0为未付款
			String orderId=request.getParameter("orderId");
			Order order=orderService.findById(Integer.parseInt(orderId));
			order.setOrderStatus(0);
			orderService.update(order);			
			response.sendRedirect(getServletContext().getContextPath()+"/app/index.do");
		}
	}

}
