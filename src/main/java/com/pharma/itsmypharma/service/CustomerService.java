package com.pharma.itsmypharma.service;

import com.pharma.itsmypharma.model.CustomerVo;

public interface CustomerService {
	
	
	public CustomerVo getOtp(String mobileNo);
	public CustomerVo verifyOtp(String customerId,String otp);

}
