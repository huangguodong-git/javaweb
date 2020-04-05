package com.hgd.hotel.mapper;

import java.util.List;

import com.hgd.hotel.po.OrderDetail;

public interface OrderDetailMapper {

	void save(OrderDetail orderDetail);

	List<OrderDetail> findByOrderId(Integer id);

}
