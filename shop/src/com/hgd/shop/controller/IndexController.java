package com.hgd.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.shop.po.Category;
import com.hgd.shop.po.PageBean;
import com.hgd.shop.po.Product;
import com.hgd.shop.service.CategoryService;
import com.hgd.shop.service.ProductService;
import com.hgd.shop.service.impl.CategoryServiceImpl;
import com.hgd.shop.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/IndexServlet")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CategoryService categoryService=new CategoryServiceImpl();
	
	private ProductService productService=new ProductServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categoryList=categoryService.findAll();
		request.setAttribute("categoryList",categoryList);
		int page = 0;
		String currPage = request.getParameter("page");
		if(currPage == null){
			page = 1;
		}else{
			page = Integer.parseInt(currPage);
		}
		PageBean<Product> pageBean = productService.findByPage(page);
		System.out.println(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
