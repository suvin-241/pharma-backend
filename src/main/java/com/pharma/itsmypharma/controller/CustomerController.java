package com.pharma.itsmypharma.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.itsmypharma.service.CustomerService;
import com.pharma.itsmypharma.service.OtpService;
import com.pharma.itsmypharma.util.PharmaConstants;

@RestController
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/api/getOtp")
	public ResponseEntity<Map<String, Object>> getOtp(@PathVariable(name="mobileNo") String mobileNo) {
		Map<String, Object> responsemap = new HashMap<>();
		responsemap.put(PharmaConstants.DATA, customerService.getOtp(mobileNo));
		responsemap.put(PharmaConstants.SUCCESS, true);
		responsemap.put(PharmaConstants.MESSAGE, "");
		return new ResponseEntity<>(responsemap, HttpStatus.OK);
	}
}
