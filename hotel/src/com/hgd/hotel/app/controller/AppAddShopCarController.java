package com.hgd.hotel.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppAddShopCarController
 */
@WebServlet("/app/shopCar.action")
public class AppAddShopCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		String dinnerTableId=request.getParameter("dinnerTableId");
		Map<Integer,Integer> shopCar=(Map<Integer, Integer>) request.getSession().getAttribute(dinnerTableId);
		String foodId=request.getParameter("foodId");
		if (method!=null && method.equals("add")) {
			if (shopCar!=null) {
				//判断商品是否是第一次添加
				Set<Integer> foodIds=shopCar.keySet();
				if (foodIds.contains(Integer.parseInt(foodId))) {
					//食品不是第一次添加
					Integer count=shopCar.get(Integer.parseInt(foodId));
					count=count+1;
					System.out.println("count===========>"+count);
					shopCar.put(Integer.parseInt(foodId),count);
				} else {
					//食品是第一次添加
					shopCar.put(Integer.parseInt(foodId),1);
				}
			} else {
				shopCar=new HashMap<Integer, Integer>();
				shopCar.put(Integer.parseInt(foodId),1);
				request.getSession().setAttribute(dinnerTableId,shopCar);
			}
			System.out.println("购物车:"+shopCar);
		}else if (method!=null && method.equals("delete")) {
			//删除购物车
			shopCar.remove(Integer.parseInt(foodId));
		}
		response.sendRedirect(getServletContext().getContextPath()+"/app/menu.action?id="+dinnerTableId);
	}

}
