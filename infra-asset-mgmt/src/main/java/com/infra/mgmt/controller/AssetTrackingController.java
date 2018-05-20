package com.infra.mgmt.controller;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infra.mgmt.manager.AssetInventoryService;

@RestController
public class AssetTrackingController {
	
	@Autowired
	AssetInventoryService assetInventoryService;
	
	@RequestMapping(value= "/getAllAssets", method = RequestMethod.GET)
	public void getActiveOrders(){
		 try {
			 assetInventoryService.getAllAssets();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
