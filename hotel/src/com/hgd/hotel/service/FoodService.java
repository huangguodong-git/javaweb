package com.hgd.hotel.service;

import java.util.List;

import com.hgd.hotel.po.Food;

public interface FoodService {

	List<Food> findAll();

	Food findById(int parseInt);

	void update(Food food);

}
