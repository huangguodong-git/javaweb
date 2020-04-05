package com.hgd.hotel.mapper;

import java.util.List;

import com.hgd.hotel.po.Food;

public interface FoodMapper {

	List<Food> findAll();

	Food findById(int id);

	void update(Food food);

	void save(Food food);

	List<Food> findByFoodTypeId(int foodTypeId);

}
