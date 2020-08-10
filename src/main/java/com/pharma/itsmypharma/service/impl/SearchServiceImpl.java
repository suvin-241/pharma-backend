package com.pharma.itsmypharma.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharma.itsmypharma.Entity.MedicalMaster;
import com.pharma.itsmypharma.dao.MedicalMasterDao;
import com.pharma.itsmypharma.model.MedicineVo;
import com.pharma.itsmypharma.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private MedicalMasterDao medicalMasterDao;
	


	@Override
	@Transactional
	public List<MedicineVo> getSearchItem(String key) {

		List<MedicalMaster> masterList = medicalMasterDao.getSearchItem(key.toUpperCase() + "%");
		List<MedicineVo> medicineList = new ArrayList<>();

		for (MedicalMaster master : masterList) {

			MedicineVo vo = new MedicineVo(master);
			medicineList.add(vo);

		}

		return medicineList;

	}

}
