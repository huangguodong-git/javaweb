package com.hgd.shop.service;

import java.util.List;

import com.hgd.shop.po.PageBean;
import com.hgd.shop.po.Product;

public interface ProductService {

	List<Product> findAll();

	void save(Product product);

	void delete(int pid);

	void update(Product product);

	Product findById(int parseInt);

	PageBean<Product> findByPage(int page);

}
