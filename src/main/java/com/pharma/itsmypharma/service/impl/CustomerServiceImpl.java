package com.pharma.itsmypharma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharma.itsmypharma.Entity.Customer;
import com.pharma.itsmypharma.dao.CustomerDao;
import com.pharma.itsmypharma.model.CustomerVo;
import com.pharma.itsmypharma.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	
	@Override
	@Transactional
	public CustomerVo createCustomer(CustomerVo customerVo) {
		
		customerVo=new CustomerVo();
		customerVo.setCustName("suvin");
		Customer customer=customerDao.save(new Customer(customerVo));
		return new CustomerVo(customer);
		
	}

}
