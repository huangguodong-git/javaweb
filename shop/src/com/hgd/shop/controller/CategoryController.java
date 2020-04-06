package com.hgd.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.shop.po.Category;
import com.hgd.shop.service.CategoryService;
import com.hgd.shop.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryServlet")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CategoryService categoryService=new CategoryServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		System.out.println("method===============>"+method);
		if (method!=null && method.equals("findAll")) {
			List<Category> list=categoryService.findAll();
			request.setAttribute("list",list);
			request.getRequestDispatcher("/WEB-INF/admin/category_list.jsp").forward(request, response);
		}else if (method!=null && method.equals("saveUI")) {
			//跳转到添加页面
			request.getRequestDispatcher("/WEB-INF/admin/category_add.jsp").forward(request, response);
		}else if (method!=null && method.equals("save")) {
			String cname=request.getParameter("cname");
			String cdesc=request.getParameter("cdesc");
			Category category=new Category();
			category.setCname(cname);
			category.setCdesc(cdesc);
			categoryService.save(category);
			response.sendRedirect(getServletContext().getContextPath()+"/CategoryServlet?method=findAll");
		}else if (method!=null && method.equals("delete")) {
			String id=request.getParameter("cid");
			Category category=new Category();
			category.setCid(Integer.parseInt(id));
			categoryService.delete(category);
			response.sendRedirect(getServletContext().getContextPath()+"/CategoryServlet?method=findAll");
		}else if (method!=null && method.equals("edit")) {
			String cid=request.getParameter("cid");
			//根据cid查询出油画分类
			Category category=categoryService.findByCid(Integer.parseInt(cid));
			request.setAttribute("category",category);
			request.getRequestDispatcher("/WEB-INF/admin/category_update.jsp").forward(request, response);
		}else if (method!=null && method.equals("update")) {
			String cname=request.getParameter("cname");
			String cdesc=request.getParameter("cdesc");
			String cid=request.getParameter("cid");
			Category category=new Category();
			category.setCid(Integer.parseInt(cid));
			category.setCname(cname);
			category.setCdesc(cdesc);
			categoryService.update(category);
			response.sendRedirect(getServletContext().getContextPath()+"/CategoryServlet?method=findAll");
		}
	}

}
