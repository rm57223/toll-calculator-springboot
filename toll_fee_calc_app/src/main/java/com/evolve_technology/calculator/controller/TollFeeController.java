package com.evolve_technology.calculator.controller;

import java.util.Map;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evolve_technology.calculator.controller.model.TollFeeDTO;
import com.evolve_technology.calculator.service.TollFeeService;

@RestController("/tollfee")
@Validated
public class TollFeeController {
	
	@Autowired
	TollFeeService tollFreeService;
	
	@GetMapping("/vehicles/{name}/dates/{date}")
	public ResponseEntity<TollFeeDTO> getTollFee(@PathVariable("name") String name,@PathVariable("date") 
	@Pattern(regexp = "^((20)[0-9][0-9])-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])T(00|0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[0-5][0-9]):(0[0-9]|[0-5][0-9])$") 
	String date) {
		Map<String,Map<Integer,Integer>> amount= tollFreeService.getTollFee(date, name);
		TollFeeDTO tollFeeDTO=new TollFeeDTO();
//		tollFeeDTO.setAmount(amount);
		tollFeeDTO.setDate(date);
		tollFeeDTO.setName(name);
		return new ResponseEntity<>(tollFeeDTO,HttpStatus.OK);
	}

	
	
	
	
	
	
	
}