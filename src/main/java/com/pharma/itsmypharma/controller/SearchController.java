package com.pharma.itsmypharma.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.itsmypharma.model.MedicineVo;
import com.pharma.itsmypharma.service.SearchService;
import com.pharma.itsmypharma.util.PharmaConstants;

@RestController
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping(value = "/api/test")
	public ResponseEntity<Map<String, Object>> test() {
		Map<String, Object> responsemap = new HashMap<>();
		responsemap.put(PharmaConstants.DATA, "hi");
		responsemap.put(PharmaConstants.SUCCESS, true);
		responsemap.put(PharmaConstants.MESSAGE, "");
		return new ResponseEntity<>(responsemap, HttpStatus.OK);
	}
	
	@GetMapping(value = "/api/seacrhMedicine/{key}")
	public ResponseEntity<Map<String, Object>> searchMedicine(@PathVariable(name="key") String key) {
		Map<String, Object> responsemap = new HashMap<>();
		
		List<MedicineVo> medicineList=searchService.getSearchItem(key);
		responsemap.put(PharmaConstants.DATA, medicineList);
		responsemap.put(PharmaConstants.SUCCESS, true);
		responsemap.put(PharmaConstants.MESSAGE, "");
		return new ResponseEntity<>(responsemap, HttpStatus.OK);
	}

}
