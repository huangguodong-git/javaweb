package com.hgd.shop.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.shop.po.Category;
import com.hgd.shop.po.Product;
import com.hgd.shop.service.CategoryService;
import com.hgd.shop.service.ProductService;
import com.hgd.shop.service.impl.CategoryServiceImpl;
import com.hgd.shop.service.impl.ProductServiceImpl;
import com.hgd.shop.util.UploadUtils;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductServlet")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService=new ProductServiceImpl();
	
	private CategoryService categoryService=new CategoryServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		System.out.println("method:------------------"+method);
		if (method!=null && method.equals("findAll")) {
			List<Product> list=productService.findAll();
			request.setAttribute("list",list);
			request.getRequestDispatcher("/WEB-INF/admin/product_list.jsp").forward(request, response);
		}else if (method!=null && method.equals("saveUI")) {
			List<Category> categoryList=categoryService.findAll();
			request.setAttribute("categoryList",categoryList);
			request.getRequestDispatcher("/WEB-INF/admin/product_add.jsp").forward(request, response);
		}else if (method!=null && method.equals("save")) {
			// 文件上传
			Map<String,String> map = UploadUtils.uploadFile(request);
			// 将数据完成封装
			Product product = new Product();
			product.setPname(map.get("pname"));
			product.setAuthor(map.get("author"));
			product.setPrice(Double.parseDouble(map.get("price")));
			product.setDescription(map.get("description"));
			product.setFilename(map.get("filename"));
			product.setPath(map.get("path"));
			product.getCategory().setCid(Integer.parseInt(map.get("cid")));
			productService.save(product);
			response.sendRedirect(getServletContext().getContextPath()+"/ProductServlet?method=findAll");
		}else if (method!=null && method.equals("delete")) {
			String pid=request.getParameter("pid");
			productService.delete(Integer.parseInt(pid));
			response.sendRedirect(getServletContext().getContextPath()+"/ProductServlet?method=findAll");
		}else if (method!=null && method.equals("edit")) {
			String pid=request.getParameter("pid");
			Product product=productService.findById(Integer.parseInt(pid));
			List<Category> categoryList=categoryService.findAll();
			request.setAttribute("categoryList",categoryList);
			request.setAttribute("product",product);
			request.getRequestDispatcher("/WEB-INF/admin/product_update.jsp").forward(request, response);
		}else if (method!=null && method.equals("update")) {
			// 接收数据
			Map<String,String> map = UploadUtils.uploadFile(request);
			// 封装数据
			Product product = new Product();
			product.setPid(Integer.parseInt(map.get("pid")));
			product.setPname(map.get("pname"));
			product.setAuthor(map.get("author"));
			product.setPrice(Double.parseDouble(map.get("price")));
			product.setDescription(map.get("description"));
			product.setFilename(map.get("filename"));
			product.setPath(map.get("path"));
			product.getCategory().setCid(Integer.parseInt(map.get("cid")));
			// 处理数据
			productService.update(product);
			response.sendRedirect(getServletContext().getContextPath()+"/ProductServlet?method=findAll");
		}
	}

}
