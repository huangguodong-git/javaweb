package com.hgd.shop.service.impl;

import java.util.List;

import com.hgd.shop.mapper.CategoryMapper;
import com.hgd.shop.po.Category;
import com.hgd.shop.service.CategoryService;
import com.hgd.shop.util.MapperUtils;

public class CategoryServiceImpl implements CategoryService {

	private CategoryMapper categoryMapper=MapperUtils.getInstence().getDao(CategoryMapper.class); 
	
	@Override
	public List<Category> findAll() {
		return categoryMapper.findAll();
	}

	@Override
	public void save(Category category) {
		categoryMapper.save(category);
	}

	@Override
	public void delete(Category category) {
		categoryMapper.delete(category);
	}

	@Override
	public Category findByCid(int cid) {
		return categoryMapper.findByCid(cid);
	}

	@Override
	public void update(Category category) {
		categoryMapper.update(category);
	}

}
