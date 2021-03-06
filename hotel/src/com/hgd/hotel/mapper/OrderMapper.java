package com.hgd.hotel.mapper;

import java.util.List;

import com.hgd.hotel.po.Order;

public interface OrderMapper {

	List<Order> findAll();

	Order findById(int id);

	void update(Order order);

	void save(Order order);

}
