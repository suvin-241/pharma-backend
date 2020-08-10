package com.pharma.itsmypharma.dao;

import java.util.List;

import com.pharma.itsmypharma.Entity.MedicalMaster;
import com.pharma.itsmypharma.common.GenericDao;

public interface MedicalMasterDao extends GenericDao<MedicalMaster>{
	
	
	List<MedicalMaster> getSearchItem(String key);

}
