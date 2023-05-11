package com.usm.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usm.service.StockPriceService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/stock")
public class StockPriceController {
	
	@Autowired
	 private StockPriceService service;
	
	@PostConstruct
	@PostMapping(path="/saveStockData")
	public void saveStockData() {
		try {
			service.saveStockDataInDb();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
