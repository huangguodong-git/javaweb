package com.hgd.hotel.sys.controller;

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

@WebServlet("/sys/foodType.action")
public class FoodTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FoodTypeService foodTypeService=new FoodTypeServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		System.out.println("=========================>"+method);
		String disabled=request.getParameter("disabled");
		String id=request.getParameter("id");
		//查询所有菜系
		if (method!=null && method.equals("list")) {
			List<FoodType> foodTypes=foodTypeService.findAll();
			for (FoodType foodType : foodTypes) {
				System.out.println(foodType);
			}
			request.setAttribute("foodTypes",foodTypes);
			request.getRequestDispatcher("/WEB-INF/jsp/sys/foodTypeList.jsp").forward(request, response);
		//更新或激活
		}else if (method!=null && method.equals("update")) {
			FoodType foodType=foodTypeService.findById(Integer.parseInt(id));
			foodType.setDisabled(Integer.parseInt(disabled));
			foodTypeService.updateFoodType(foodType);
			response.sendRedirect(getServletContext().getContextPath()+"/sys/foodType.action?method=list");
		//跳转到更新页面
		}else if (method!=null && method.equals("viewUpdate")) {
			FoodType foodType=foodTypeService.findById(Integer.parseInt(id));
			request.setAttribute("foodType", foodType);
			request.getRequestDispatcher("/WEB-INF/jsp/sys/foodTypeUpdate.jsp").forward(request, response);
		//更新
		}else if (method!=null && method.equals("updateSubmit")) {
			String foodTypeName=request.getParameter("foodTypeName");
			String ids=request.getParameter("id");
			System.out.println(ids+"==========="+foodTypeName);
			FoodType foodType=foodTypeService.findById(Integer.parseInt(ids));
			foodType.setTypeName(foodTypeName);
			foodTypeService.updateFoodType(foodType);
			response.sendRedirect(getServletContext().getContextPath()+"/sys/foodType.action?method=list");
		//跳转到添加页面
		}else if (method!=null && method.equals("addPage")) {
			request.getRequestDispatcher("/WEB-INF/jsp/sys/foodTypeAdd.jsp").forward(request, response);
		//处理添加
		}else if (method!=null && method.equals("addSubmit")) {
			String foodTypeName=request.getParameter("foodTypeName");
			FoodType foodType=new FoodType();
			foodType.setTypeName(foodTypeName);
			foodTypeService.save(foodType);
			response.sendRedirect(getServletContext().getContextPath()+"/sys/foodType.action?method=list");
		}
	}

}
