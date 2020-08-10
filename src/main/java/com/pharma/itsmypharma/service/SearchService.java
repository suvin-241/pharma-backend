package com.pharma.itsmypharma.service;

import java.util.List;

import com.pharma.itsmypharma.model.MedicineVo;

public interface SearchService {

	
	public List<MedicineVo> getSearchItem(String key);
}
