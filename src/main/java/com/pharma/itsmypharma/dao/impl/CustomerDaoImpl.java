package com.pharma.itsmypharma.dao.impl;

import org.springframework.stereotype.Repository;

import com.pharma.itsmypharma.Entity.Customer;
import com.pharma.itsmypharma.common.GenericDaoImpl;
import com.pharma.itsmypharma.dao.CustomerDao;

@Repository
@SuppressWarnings("unchecked")
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao{

}
