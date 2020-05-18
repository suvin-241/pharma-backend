package com.pharma.itsmypharma.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.itsmypharma.common.PharmaException;
import com.pharma.itsmypharma.model.UserVo;
import com.pharma.itsmypharma.service.UserService;
import com.pharma.itsmypharma.util.PharmaConstants;


@RestController
@CrossOrigin
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	

	@GetMapping(value = "/api/test")
	public ResponseEntity<Map<String, Object>> test() {
		Map<String, Object> responsemap = new HashMap<>();
		responsemap.put(PharmaConstants.DATA, "hi");
		responsemap.put(PharmaConstants.SUCCESS, true);
		responsemap.put(PharmaConstants.MESSAGE, "");
		return new ResponseEntity<>(responsemap, HttpStatus.OK);
	}

	@PostMapping(value="/api/addUser")
	public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserVo uservo) throws PharmaException{
		Map<String, Object> responsemap = new HashMap<>();
		responsemap.put(PharmaConstants.DATA, userService.createUser(uservo));
		responsemap.put(PharmaConstants.SUCCESS, true);
		responsemap.put(PharmaConstants.MESSAGE, "");
		return new ResponseEntity<>(responsemap, HttpStatus.OK);
	}
	
	@PostMapping(value="/api/auth")
	public ResponseEntity<Map<String, Object>> authUser(@RequestBody UserVo uservo) throws PharmaException{
		Map<String, Object> responsemap = new HashMap<>();
		responsemap.put(PharmaConstants.DATA, userService.authUser(uservo));
		responsemap.put(PharmaConstants.SUCCESS, true);
		responsemap.put(PharmaConstants.MESSAGE, "");
		return new ResponseEntity<>(responsemap, HttpStatus.OK);
	}

}
