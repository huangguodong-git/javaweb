package com.hgd.hotel.service;

import java.util.List;

import com.hgd.hotel.po.Order;

public interface OrderService {

	List<Order> findAll();

	Order findById(int parseInt);

	void update(Order order);

}
