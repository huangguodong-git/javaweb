package com.hgd.hotel.service.impl;

import java.util.List;

import com.hgd.hotel.mapper.FoodTypeMapper;
import com.hgd.hotel.po.FoodType;
import com.hgd.hotel.service.FoodTypeService;
import com.hgd.hotel.util.MapperUtils;

public class FoodTypeServiceImpl implements FoodTypeService {

	private FoodTypeMapper foodTypeMapper=MapperUtils.getInstence().getDao(FoodTypeMapper.class);
	
	@Override
	public List<FoodType> findAll() {
		System.out.println("============>"+MapperUtils.getInstence().getDao(FoodTypeMapper.class).findAll());
		return foodTypeMapper.findAll();
	}

}
