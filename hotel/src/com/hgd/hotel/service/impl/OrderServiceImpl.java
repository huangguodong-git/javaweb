package com.hgd.hotel.service.impl;

import java.util.List;

import com.hgd.hotel.mapper.DinnerTableMapper;
import com.hgd.hotel.mapper.FoodMapper;
import com.hgd.hotel.mapper.OrderDetailMapper;
import com.hgd.hotel.mapper.OrderMapper;
import com.hgd.hotel.po.DinnerTable;
import com.hgd.hotel.po.Food;
import com.hgd.hotel.po.Order;
import com.hgd.hotel.po.OrderDetail;
import com.hgd.hotel.service.OrderService;
import com.hgd.hotel.util.MapperUtils;

public class OrderServiceImpl implements OrderService {

	private OrderMapper orderMapper=MapperUtils.getInstence().getDao(OrderMapper.class);
	
	private OrderDetailMapper orderDetailMapper=MapperUtils.getInstence().getDao(OrderDetailMapper.class);
	
	private DinnerTableMapper dinnerTableMapper=MapperUtils.getInstence().getDao(DinnerTableMapper.class);
	
	private FoodMapper foodMapper=MapperUtils.getInstence().getDao(FoodMapper.class);
	
	@Override
	public List<Order> findAll() {
		List<Order> orders=orderMapper.findAll();
		//遍历所有的订单，根据订单id查询其对于订单明细
		if(orders != null && orders.size()>0) {
			for (Order order : orders) {
				List<OrderDetail>  details = orderDetailMapper.findByOrderId(order.getId());
				for (OrderDetail orderDetail : details) {
					//查询出食品
					Food food=foodMapper.findById(orderDetail.getFoodId());
					orderDetail.setFoodId(food.getId());
					orderDetail.setFood(food);
				}
				if(details != null && details.size()>0) {
					order.setOrderDetails(details);
				}		
				//通过餐桌的id查询餐桌
				DinnerTable dinnerTable = dinnerTableMapper.findByDinnerTableId(order.getTableId());	
				order.setDinnerTable(dinnerTable);
			}
		}
		return orders;
	}

	@Override
	public Order findById(int id) {
		return orderMapper.findById(id);
	}

	@Override
	public void update(Order order) {
		orderMapper.update(order);
	}

	@Override
	public void save(Order order) {
		orderMapper.save(order);
	}

}
