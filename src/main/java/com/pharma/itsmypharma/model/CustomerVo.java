package com.pharma.itsmypharma.model;

import java.math.BigInteger;

import com.pharma.itsmypharma.Entity.Customer;

public class CustomerVo {

	
	public CustomerVo() {
		
	}
	private BigInteger customerId;
	private String custName;

	public BigInteger getCustomerId() {
		return customerId;
	}

	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public CustomerVo(Customer customer) {
		
		this.customerId=customer.getCustomerId();
		this.custName=customer.getCustName();

	}
}
