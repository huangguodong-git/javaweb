package com.hgd.hotel.service.impl;

import java.util.List;
import java.util.Map;

import com.hgd.hotel.mapper.DinnerTableMapper;
import com.hgd.hotel.po.DinnerTable;
import com.hgd.hotel.service.DinnerTableService;
import com.hgd.hotel.util.MapperUtils;

public class DinnerTableServiceImpl implements DinnerTableService {

	private DinnerTableMapper dinnerTableMapper=MapperUtils.getInstence().getDao(DinnerTableMapper.class);
	
	@Override
	public List<DinnerTable> findAll(Map<String,Object> map) {
		System.out.println("=======================>"+MapperUtils.getInstence().getDao(DinnerTableMapper.class).findAll());
		return dinnerTableMapper.findAll();
	}

	@Override
	public DinnerTable findByDinnerTableId(Integer id) {
		return dinnerTableMapper.findByDinnerTableId(id);
	}

	@Override
	public void updateDinnerTable(DinnerTable dinnerTable) {
		dinnerTableMapper.updateDinnerTable(dinnerTable);
	}

	@Override
	public void save(DinnerTable dinnerTable) {
		dinnerTableMapper.save(dinnerTable);
	}

}
