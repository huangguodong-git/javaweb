package com.hgd.hotel.mapper;

import java.util.List;
import java.util.Map;

import com.hgd.hotel.dto.DinnerTableDto;
import com.hgd.hotel.po.DinnerTable;

public interface DinnerTableMapper {
	//��ѯ����
	List<DinnerTable> findAll();
	
	DinnerTable findByDinnerTableId(Integer id);

	void updateDinnerTable(DinnerTable dinnerTable);

	void save(DinnerTable dinnerTable);

	List<DinnerTable> findByNameAndStatus(DinnerTableDto dinnerTableDto);
	
}
