package com.hgd.hotel.sys.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.hgd.hotel.po.Food;
import com.hgd.hotel.po.FoodType;
import com.hgd.hotel.service.FoodService;
import com.hgd.hotel.service.FoodTypeService;
import com.hgd.hotel.service.impl.FoodServiceImpl;
import com.hgd.hotel.service.impl.FoodTypeServiceImpl;

@WebServlet("/sys/food.action")
@MultipartConfig
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FoodService foodService=new FoodServiceImpl();
	
	private FoodTypeService foodTypeService=new FoodTypeServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		String id=request.getParameter("id");
		String disabled=request.getParameter("disabled"); 
		String foodName = request.getParameter("foodName");
		System.out.println("===================>"+foodName);
		String  price = request.getParameter("price");
		String  discount = request.getParameter("discount");
		String remark = request.getParameter("remark");
		String foodTypeId = request.getParameter("foodTypeId");
		//��ѯ���в�Ʒ
		if (method!=null && method.equals("list")) {
			List<Food> foods=foodService.findAll();
			request.setAttribute("foods",foods);
			request.getRequestDispatcher("/WEB-INF/jsp/sys/foodList.jsp").forward(request, response);
		//�޸�
		}else if (method!=null && method.equals("update")) {
			Food food=foodService.findById(Integer.parseInt(id));
			food.setDisabled(Integer.parseInt(disabled));
			//����
			foodService.update(food);
			response.sendRedirect(getServletContext().getContextPath()+"/sys/food.action?method=list");
		}else if (method!=null && method.equals("viewUpdate")) {
			//��ת������ҳ��
			Food food=foodService.findById(Integer.parseInt(id));
			request.setAttribute("food", food);
			//��ѯ��ϵ
			List<FoodType> foodTypes=foodTypeService.findAll();
			request.setAttribute("foodTypes",foodTypes);
			request.getRequestDispatcher("/WEB-INF/jsp/sys/foodUpdate.jsp").forward(request, response);
		}else if (method!=null && method.equals("updateSubmit")) {
			//�ϴ�ͼƬ
			Part part=request.getPart("img");
			//�ϴ�ͼƬ����ĿĿ¼
			String path=getServletContext().getRealPath("upload/food");
			System.out.println("path===============>"+path);
			File file=new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			//��ȡ�ϴ���Ŀ��
			System.out.println("��Ŀ��:"+part.getSubmittedFileName());
			String imgName=part.getSubmittedFileName();
			//��ȡ�ļ���
			String fileName=imgName.substring(imgName.lastIndexOf("."));
			String name=UUID.randomUUID().toString();
			StringBuffer newName=new StringBuffer();
			newName.append(name).append(fileName);
			//��ͼƬд��ָ����λ��
			part.write(path+file.separator+newName);
			System.out.println("===========>"+path+file.separator+newName);
			Food food=new Food();
			food.setId(Integer.parseInt(id));
			food.setFoodName(foodName);
			food.setFoodTypeId(Integer.parseInt(foodTypeId));
			food.setPrice(Double.parseDouble(price));
			food.setRemark(remark);
			food.setImg(newName.toString());
			food.setDiscount(Double.parseDouble(discount));
			food.setDisabled(0);
			//����
			foodService.update(food);
			response.sendRedirect(getServletContext().getContextPath()+"/sys/food.action?method=list");
		}else if (method!=null && method.equals("addPage")) {
			//��ѯ��ϵ
			List<FoodType> foodTypes=foodTypeService.findAll();
			request.setAttribute("foodTypes",foodTypes);
			request.getRequestDispatcher("/WEB-INF/jsp/sys/foodAdd.jsp").forward(request,response);
		}else if (method!=null && method.equals("addSubmit")) {
			//�ϴ�ͼƬ
			Part part=request.getPart("img");
			//�ϴ�ͼƬ����ĿĿ¼
			String path=getServletContext().getRealPath("upload/food");
			System.out.println("path===============>"+path);
			File file=new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			//��ȡ�ϴ���Ŀ��
			System.out.println("��Ŀ��:"+part.getSubmittedFileName());
			String imgName=part.getSubmittedFileName();
			//��ȡ�ļ���
			String fileName=imgName.substring(imgName.lastIndexOf("."));
			String name=UUID.randomUUID().toString();
			StringBuffer newName=new StringBuffer();
			newName.append(name).append(fileName);
			//��ͼƬд��ָ����λ��
			part.write(path+file.separator+newName);
			System.out.println("===========>"+path+file.separator+newName);
			Food food=new Food();
			food.setFoodName(foodName);
			food.setFoodTypeId(Integer.parseInt(foodTypeId));
			food.setPrice(Double.parseDouble(price));
			food.setRemark(remark);
			food.setImg(newName.toString());
			food.setDiscount(Double.parseDouble(discount));
			food.setDisabled(0);
			//����
			foodService.save(food);
			response.sendRedirect(getServletContext().getContextPath()+"/sys/food.action?method=list");
		}
	}

}
