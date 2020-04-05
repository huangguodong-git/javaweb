package com.hgd.hotel.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.hotel.po.Food;
import com.hgd.hotel.po.FoodType;
import com.hgd.hotel.service.FoodService;
import com.hgd.hotel.service.FoodTypeService;
import com.hgd.hotel.service.impl.FoodServiceImpl;
import com.hgd.hotel.service.impl.FoodTypeServiceImpl;

/**
 * Servlet implementation class AppMeauListController
 */
@WebServlet("/app/menuList.do")
public class AppMeauListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FoodTypeService foodTypeService=new FoodTypeServiceImpl();
	
	private FoodService foodService=new FoodServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodType> foodTypes=foodTypeService.findAll();
		request.setAttribute("foodTypes",foodTypes);
		System.out.println(foodTypes.get(0).getId());
		String foodTypeId=request.getParameter("foodTypeId");
		List<Food> foods=null;
		if (foodTypeId==null) {
			foods=foodService.findByFoodTypeId(foodTypes.get(0).getId());
		}else {
			foods=foodService.findByFoodTypeId(Integer.parseInt(foodTypeId));
		}
		request.setAttribute("foods",foods);
		request.getRequestDispatcher("/WEB-INF/jsp/app/menuList.jsp").forward(request, response);
	}

}
