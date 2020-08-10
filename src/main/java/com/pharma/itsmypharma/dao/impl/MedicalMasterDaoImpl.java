package com.pharma.itsmypharma.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pharma.itsmypharma.Entity.MedicalMaster;
import com.pharma.itsmypharma.common.GenericDaoImpl;
import com.pharma.itsmypharma.common.QueryConstants;
import com.pharma.itsmypharma.dao.MedicalMasterDao;

@Repository
@SuppressWarnings("all")
public class MedicalMasterDaoImpl extends GenericDaoImpl<MedicalMaster> implements MedicalMasterDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicalMasterDaoImpl.class);

	public MedicalMasterDaoImpl() {
		super(MedicalMaster.class);
	}

	@Override
	public List<MedicalMaster> getSearchItem(String key) {

		LOGGER.info("query {}", QueryConstants.getQuery(QueryConstants.GET_MEDICINE_BY_SEARCH_KEY));
		Query query = getEntityManager()
				.createQuery(QueryConstants.getQuery(QueryConstants.GET_MEDICINE_BY_SEARCH_KEY));
		query.setParameter(QueryConstants.ARG1, key);
		query.setMaxResults(10);
		
		return query.getResultList();

	}

}
