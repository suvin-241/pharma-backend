package com.pharma.itsmypharma.dao.impl;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pharma.itsmypharma.Entity.Customer;
import com.pharma.itsmypharma.common.GenericDaoImpl;
import com.pharma.itsmypharma.common.QueryConstants;
import com.pharma.itsmypharma.dao.CustomerDao;

public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao{

	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

	public CustomerDaoImpl() {
		super(Customer.class);
	}

	@Override
	public Customer getCustomerbyMobileNo(String mobileNo) {
		LOGGER.info("query {}", QueryConstants.getQuery(QueryConstants.GET_CUSTOMER_BY_MOBOLE_NO));
		Query query = getEntityManager()
				.createQuery(QueryConstants.getQuery(QueryConstants.GET_CUSTOMER_BY_MOBOLE_NO));
		query.setParameter(QueryConstants.ARG1, mobileNo);
		
		
		return (Customer)query.getSingleResult();

		
	}
}
