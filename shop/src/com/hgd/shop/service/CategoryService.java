package com.hgd.shop.service;

import java.util.List;

import com.hgd.shop.po.Category;

public interface CategoryService {

	List<Category> findAll();

	void save(Category category);

	void delete(Category category);

	Category findByCid(int cid);

	void update(Category category);

}
