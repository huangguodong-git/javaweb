package com.hgd.shop.service.impl;

import java.util.List;

import com.hgd.shop.dto.PageDto;
import com.hgd.shop.mapper.ProductMapper;
import com.hgd.shop.po.PageBean;
import com.hgd.shop.po.Product;
import com.hgd.shop.service.ProductService;
import com.hgd.shop.util.MapperUtils;

public class ProductServiceImpl implements ProductService {

	private ProductMapper productMapper=MapperUtils.getInstence().getDao(ProductMapper.class);
	
	@Override
	public List<Product> findAll() {
		return productMapper.findAll();
	}

	@Override
	public void save(Product product) {
		productMapper.save(product);
	}

	@Override
	public void delete(int pid) {
		productMapper.delete(pid);
	}

	@Override
	public void update(Product product) {
		productMapper.update(product);
	}

	@Override
	public Product findById(int pid) {
		return productMapper.findById(pid);
	}

	@Override
	public PageBean<Product> findByPage(int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 封装当前的页数:
		pageBean.setPage(page);
		// 封装每页显示记录数:
		int limit = 6;
		pageBean.setLimit(limit);
		// 封装总记录数:
		int totalCount = productMapper.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装总页数:(根据总记录数进行计算)
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit +1;
		}
		pageBean.setTotalPage(totalPage);
		// 封装每页显示数据的集合:select * from xx limit begin,limit;
		int begin = (page -1) * limit;
		PageDto pageDto=new PageDto();
		pageDto.setBegin(begin);
		pageDto.setLimit(limit);
		List<Product> list = productMapper.findByPage(pageDto);
		pageBean.setList(list);
		return null;
	}

}
