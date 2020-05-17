package com.pharma.itsmypharma.common;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.itsmypharma.util.PharmaConstants;
import com.pharma.itsmypharma.util.PharmaResourceBundle;


@ControllerAdvice(annotations = RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE)

 
public class ControllerExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Map<String, Object>> handleException(Exception e) {

		logger.error("Error occured Exception || SQLException {}", e);
		Map<String, Object> errorMap = new HashMap<>();
		
		errorMap.put(PharmaConstants.DATA,
				PharmaResourceBundle.getProperty(ResourceBundleConstants.GENERIC_DB_FAILURE));
		
		errorMap.put(PharmaConstants.MESSAGE,
				PharmaResourceBundle.getProperty(ResourceBundleConstants.GENERIC_DB_FAILURE));
		errorMap.put(PharmaConstants.SUCCESS, false);
		return new ResponseEntity<>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler({ PharmaException.class })
	public ResponseEntity<Map<String, Object>> handleKaizenException(PharmaException e) {

		logger.error("Error occured KaizenException {}", e);
		Map<String, Object> errorMap = new HashMap<>();
		if (e.getErrorList() != null) {
			errorMap.put(PharmaConstants.DATA, e.getErrorList());
			errorMap.put(PharmaConstants.MESSAGE, e.getMessage());
		} else {
			errorMap.put(PharmaConstants.DATA, e.getMessage());
			errorMap.put(PharmaConstants.MESSAGE, e.getMessage());
		}
		errorMap.put(PharmaConstants.SUCCESS, false);
		return new ResponseEntity<>(errorMap, HttpStatus.UNPROCESSABLE_ENTITY);
	}



}
