package com.usm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.usm.model.PortfolioDetails;
import com.usm.service.PortfolioDetailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/header")
@CrossOrigin("*")
public class PortfolioDetailController {
	
	@Autowired
    PortfolioDetailService service;

    @PostMapping("/addPortfolio")
    public ResponseEntity<PortfolioDetails> addPortfolio(@Valid @RequestBody PortfolioDetails ph)
    {
    	PortfolioDetails portfolio=service.addPortfolio(ph);

        return new ResponseEntity<>(portfolio,HttpStatus.OK);

    }
    @GetMapping("/fetchAllportfolio") 
	public ResponseEntity<List<PortfolioDetails>> getAllPortfolioData() {
		List<PortfolioDetails> dataList = service.fetchAllMasterData();
		return new ResponseEntity<>(dataList, HttpStatus.OK);
	}
    
    @GetMapping("/fetchByName/{portfolioName}")
    public ResponseEntity<PortfolioDetails> getByName(@PathVariable("portfolioName")String portfolioName)
    {
    	PortfolioDetails pd = service.findByName(portfolioName);
    	return new ResponseEntity<>(pd,HttpStatus.OK);
    }
	  
	  
	 
	  
	  
}
