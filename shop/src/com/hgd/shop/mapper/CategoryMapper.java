package com.hgd.shop.mapper;

import java.util.List;

import com.hgd.shop.po.Category;

public interface CategoryMapper {

	List<Category> findAll();

	void save(Category category);

	void delete(Category category);

	Category findByCid(int cid);

	void update(Category category);

}
