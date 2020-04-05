package com.hgd.hotel.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.hotel.po.DinnerTable;
import com.hgd.hotel.service.DinnerTableService;
import com.hgd.hotel.service.impl.DinnerTableServiceImpl;

/**
 * Servlet implementation class AppDinnerTableController
 */
@WebServlet("/app/dinnerTable.action")
public class AppDinnerTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DinnerTableService dinnerTableService=new DinnerTableServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dinnerTableId = request.getParameter("dinnerTableId");
		String tableStatus = request.getParameter("tableStatus");
		System.out.println("--------------"+dinnerTableId+"====="+tableStatus);
		DinnerTable dinnerTable=dinnerTableService.findByDinnerTableId(Integer.parseInt(dinnerTableId));
		dinnerTable.setTableStatus(Integer.parseInt(tableStatus));
		//修改餐厅使用状态(是否使用)
		dinnerTableService.updateDinnerTable(dinnerTable);
		response.sendRedirect(getServletContext().getContextPath()+"/app/menu.action?id="+dinnerTableId);
	}

}
