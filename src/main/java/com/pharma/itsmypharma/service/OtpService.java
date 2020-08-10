package com.pharma.itsmypharma.service;

public interface OtpService {

	
	public String generateOtp(String mobileNo);
	public String verifyOtp(String custId,String otp);
}
