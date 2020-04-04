package com.hgd.hotel.service.impl;

import java.util.List;

import com.hgd.hotel.mapper.OrderMapper;
import com.hgd.hotel.po.Order;
import com.hgd.hotel.service.OrderService;
import com.hgd.hotel.util.MapperUtils;

public class OrderServiceImpl implements OrderService {

	private OrderMapper orderMapper=MapperUtils.getInstence().getDao(OrderMapper.class);
	
	@Override
	public List<Order> findAll() {
		return orderMapper.findAll();
	}

	@Override
	public Order findById(int id) {
		return orderMapper.findById(id);
	}

	@Override
	public void update(Order order) {
		orderMapper.update(order);
	}

}
