package com.hgd.hotel.service.impl;

import java.util.List;

import com.hgd.hotel.mapper.FoodMapper;
import com.hgd.hotel.po.Food;
import com.hgd.hotel.service.FoodService;
import com.hgd.hotel.util.MapperUtils;

public class FoodServiceImpl implements FoodService {

	private FoodMapper foodMapper=MapperUtils.getInstence().getDao(FoodMapper.class);
	
	@Override
	public List<Food> findAll() {
		return foodMapper.findAll();
	}

	@Override
	public Food findById(int id) {
		return foodMapper.findById(id);
	}

	@Override
	public void update(Food food) {
		foodMapper.update(food);
	}

	@Override
	public void save(Food food) {
		foodMapper.save(food);
	}

	@Override
	public List<Food> findByFoodTypeId(int foodTypeId) {
		return foodMapper.findByFoodTypeId(foodTypeId);
	}

}
