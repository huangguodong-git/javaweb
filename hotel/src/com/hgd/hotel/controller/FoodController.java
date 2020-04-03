package com.hgd.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.hotel.po.Food;
import com.hgd.hotel.service.FoodService;
import com.hgd.hotel.service.impl.FoodServiceImpl;

@WebServlet("/sys/food.action")
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FoodService foodService=new FoodServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		String id=request.getParameter("id");
		String disabled=request.getParameter("disabled"); 
		//查询所有菜品
		if (method!=null && method.equals("list")) {
			List<Food> foods=foodService.findAll();
			request.setAttribute("foods",foods);
			request.getRequestDispatcher("/WEB-INF/jsp/sys/foodList.jsp").forward(request, response);
		//修改
		}else if (method!=null && method.equals("update")) {
			Food food=foodService.findById(Integer.parseInt(id));
			food.setDisabled(Integer.parseInt(disabled));
			foodService.update(food);
			response.sendRedirect(getServletContext().getContextPath()+"/sys/food.action?method=list");
		}
	}

}
