package com.pharma.itsmypharma.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.itsmypharma.service.CustomerService;
import com.pharma.itsmypharma.util.PharmaConstants;


@RestController
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	

	@GetMapping(value = "/api/test")
	public ResponseEntity<Map<String, Object>> test() {
		Map<String, Object> responsemap = new HashMap<>();
		responsemap.put(PharmaConstants.DATA, "hi");
		responsemap.put(PharmaConstants.SUCCESS, true);
		responsemap.put(PharmaConstants.MESSAGE, "");
		return new ResponseEntity<>(responsemap, HttpStatus.OK);
	}

	@GetMapping(value = "/api/testConnection")
	public ResponseEntity<Map<String, Object>> testConnection() {
		Map<String, Object> responsemap = new HashMap<>();
		responsemap.put(PharmaConstants.DATA, customerService.createCustomer(null));
		responsemap.put(PharmaConstants.SUCCESS, true);
		responsemap.put(PharmaConstants.MESSAGE, "");
		return new ResponseEntity<>(responsemap, HttpStatus.OK);
	}
}
