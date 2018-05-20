package com.infra.mgmt.controller;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infra.mgmt.manager.OrderTrackingService;

@RestController
public class OrderController {
	
	@Autowired
	OrderTrackingService orderTrackingService;
	
	@RequestMapping(value= "/getActiveOrders", method = RequestMethod.GET)
	public void getActiveOrders(){
		 try {
			orderTrackingService.getAllActiveOrders();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	

}
