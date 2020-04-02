package com.hgd.hotel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hgd.hotel.po.DinnerTable;
import com.hgd.hotel.service.DinnerTableService;
import com.hgd.hotel.service.impl.DinnerTableServiceImpl;

@WebServlet("/sys/dinnerTable.action")
public class DinnertableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DinnerTableService dinnerTableService=new DinnerTableServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		String tableName=request.getParameter("keyword");
		String tableStatus=request.getParameter("tableStatus");
		String disabled=request.getParameter("disabled");
		if (method!=null && method.equals("list")) {
			Map<String,Object> map=new HashMap<>();
			map.put("tableName",tableName);
			map.put("tableStatus",tableStatus);
			map.put("disabled",disabled);
			List<DinnerTable> dinnerTables=dinnerTableService.findAll(map);
			for (DinnerTable dinnerTable2 : dinnerTables) {
				System.out.println(dinnerTable2);
			}
			request.setAttribute("dinnerTables",dinnerTables);
			request.getRequestDispatcher("/WEB-INF/jsp/sys/dinnerTableList.jsp").forward(request, response);
		}else if(method!=null && method.equals("update")) {
			Integer id=Integer.parseInt(request.getParameter("id"));
			DinnerTable dinnerTable=dinnerTableService.findByDinnerTableId(id);
			dinnerTable.setDisabled(Integer.parseInt(disabled));
			//更新
			dinnerTableService.updateDinnerTable(dinnerTable);
			response.sendRedirect(getServletContext().getContextPath()+"/sys/dinnerTable.action?method=list");
		}else if(method!=null && method.equals("addPage")) {
			request.getRequestDispatcher("/WEB-INF/jsp/sys/dinnerTableAdd.jsp").forward(request, response);
		}else if(method!=null && method.equals("addSubmit")) {
			String tableName1=request.getParameter("tableName");
			DinnerTable dinnerTable=new DinnerTable();
			dinnerTable.setTableName(tableName1);
			//保存操作
			dinnerTableService.save(dinnerTable);
			response.sendRedirect(getServletContext().getContextPath()+"/sys/dinnerTable.action?method=list");
		}
		
	}

}
