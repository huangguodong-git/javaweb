package com.hgd.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.hotel.po.FoodType;
import com.hgd.hotel.service.FoodTypeService;
import com.hgd.hotel.service.impl.FoodTypeServiceImpl;


@WebServlet("/sys/food.action")
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FoodTypeService foodTypeService=new FoodTypeServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if (method!=null && method.equals("list")) {
			List<FoodType> foodTypes=foodTypeService.findAll();
			for (FoodType foodType : foodTypes) {
				System.out.println(foodType);
			}
			request.setAttribute("foodTypes",foodTypes);
			request.getRequestDispatcher("/WEB-INF/jsp/sys/foodList.jsp").forward(request, response);
		}
	}

}
