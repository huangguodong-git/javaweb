package com.hgd.hotel.service;

import java.util.List;

import com.hgd.hotel.po.FoodType;

public interface FoodTypeService {

	List<FoodType> findAll();

	FoodType findById(Integer id);

	void updateFoodType(FoodType foodType);

	FoodType findByTypeName(String foodTypeName);

	void save(FoodType foodType);
	
}
