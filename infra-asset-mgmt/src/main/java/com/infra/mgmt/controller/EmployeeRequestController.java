package com.infra.mgmt.controller;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infra.mgmt.manager.EmployeeRequestService;

@RestController
public class EmployeeRequestController {

	@Autowired
	EmployeeRequestService employeeRequestService;
	
	@RequestMapping(value= "/getEmployeeRequests", method = RequestMethod.GET)
	public void getActiveOrders(){
		 try {
			 employeeRequestService.getAllEmployeeRequests();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
