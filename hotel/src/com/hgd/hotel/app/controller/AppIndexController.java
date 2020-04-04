package com.hgd.hotel.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.hotel.dto.DinnerTableDto;
import com.hgd.hotel.po.DinnerTable;
import com.hgd.hotel.service.DinnerTableService;
import com.hgd.hotel.service.impl.DinnerTableServiceImpl;

/**
 * Servlet implementation class AppIndexController
 */
@WebServlet("/app/index.do")
public class AppIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DinnerTableService dinnerTableService=new DinnerTableServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		//if (method!=null && method.equals("submitTable")) {
			String tableName=request.getParameter("tableName");
			String tableStatus=request.getParameter("tableStatus");
			String disabled=request.getParameter("disabled");
			Map<String,Object> map=new HashMap<>();
			map.put("tableName",tableName);
			map.put("tableStatus",tableStatus);
			map.put("disabled",disabled);
			List<DinnerTable> dinnerTables=dinnerTableService.findAll(map);
			request.setAttribute("dinnerTables",dinnerTables);
			request.getRequestDispatcher("/WEB-INF/jsp/app/index.jsp").forward(request, response);
		//}
	}

}
