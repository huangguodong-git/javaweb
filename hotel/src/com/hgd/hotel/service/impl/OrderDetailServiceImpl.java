package com.hgd.hotel.service.impl;

import com.hgd.hotel.mapper.OrderDetailMapper;
import com.hgd.hotel.po.OrderDetail;
import com.hgd.hotel.service.OrderDetailService;
import com.hgd.hotel.util.MapperUtils;

public class OrderDetailServiceImpl implements OrderDetailService {

	private OrderDetailMapper orderDetailMapper=MapperUtils.getInstence().getDao(OrderDetailMapper.class);
	
	@Override
	public void save(OrderDetail orderDetail) {
		orderDetailMapper.save(orderDetail);
	}

}
