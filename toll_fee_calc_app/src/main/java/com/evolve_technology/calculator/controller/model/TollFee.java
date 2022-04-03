package com.evolve_technology.calculator.controller.model;

import java.util.Map;

import lombok.Data;

@Data
public class TollFee {
	String vehicle;
	String date;
	int totalAmount;
	Map<String,String> travelRecordsWithinDay;
}
