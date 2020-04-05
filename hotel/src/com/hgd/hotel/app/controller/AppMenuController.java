package com.hgd.hotel.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.hotel.po.DinnerTable;
import com.hgd.hotel.po.Food;
import com.hgd.hotel.po.FoodType;
import com.hgd.hotel.service.DinnerTableService;
import com.hgd.hotel.service.FoodService;
import com.hgd.hotel.service.FoodTypeService;
import com.hgd.hotel.service.impl.DinnerTableServiceImpl;
import com.hgd.hotel.service.impl.FoodServiceImpl;
import com.hgd.hotel.service.impl.FoodTypeServiceImpl;

/**
 * Servlet implementation class AppMenuController
 */
@WebServlet("/app/menu.action")
public class AppMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FoodTypeService foodTypeService=new FoodTypeServiceImpl();
	
	private FoodService foodService=new FoodServiceImpl();
	
	private DinnerTableService dinnerTableService=new DinnerTableServiceImpl();
	
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
		String dinnerTableId=request.getParameter("id");
		//if (dinnerTableId!=null) {
			DinnerTable dinnerTable=dinnerTableService.findByDinnerTableId(Integer.parseInt(dinnerTableId));
			request.setAttribute("dinnerTable",dinnerTable);
		//}
		//显示购物车
		Map<Integer,Integer> shopCar=(Map<Integer, Integer>) request.getSession().getAttribute(dinnerTableId);
		List<Food>  foods2 = new ArrayList<>();
		//计算购物车中商品总金额
		Double total = 0.00;
		if (shopCar!=null) {
			Set<Integer> foodIds=shopCar.keySet();
			for (Integer foodId : foodIds) {
				//查询出食品
				Food food=foodService.findById(foodId);
				//获取购物车食品的数量
				food.setBuyNum(shopCar.get(foodId));
				System.out.println("food:"+food);
				foods2.add(food);
				//当前商品购买需要的价格
				Double price=food.getBuyNum()*food.getDiscount()*food.getPrice();
				total+=price;
			}
		}
		request.setAttribute("foods2", foods2);
		request.setAttribute("total", total);
		request.getRequestDispatcher("/WEB-INF/jsp/app/menu.jsp").forward(request, response);
	}

}
