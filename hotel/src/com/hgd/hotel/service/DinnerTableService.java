package com.hgd.hotel.service;

import java.util.List;
import java.util.Map;

import com.hgd.hotel.dto.DinnerTableDto;
import com.hgd.hotel.po.DinnerTable;

public interface DinnerTableService {

	List<DinnerTable> findAll(Map<String,Object> map);
	
	DinnerTable findByDinnerTableId(Integer id);

	void updateDinnerTable(DinnerTable dinnerTable);

	void save(DinnerTable dinnerTable);

	List<DinnerTable> findByNameAndStatus(DinnerTableDto dinnerTableDto);
	
}
