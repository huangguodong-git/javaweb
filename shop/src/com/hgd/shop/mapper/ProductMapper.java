package com.hgd.shop.mapper;

import java.util.List;

import com.hgd.shop.dto.PageDto;
import com.hgd.shop.po.Product;

public interface ProductMapper {

	List<Product> findAll();

	void save(Product product);

	void delete(int pid);

	void update(Product product);

	Product findById(int pid);

	int findCount();

	List<Product> findByPage(PageDto pageDto);

}
