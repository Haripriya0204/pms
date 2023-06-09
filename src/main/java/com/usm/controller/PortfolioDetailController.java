package com.usm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usm.dto.DetailsDTO;
import com.usm.model.PortfolioDetails;
import com.usm.model.Themes;
import com.usm.service.PortfolioDetailService;
import com.usm.service.ThemesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/header")
@CrossOrigin("*")
public class PortfolioDetailController {
	
	@Autowired
    PortfolioDetailService service;
	
	
	@Autowired
	ThemesService ts;

    @PostMapping("/addPortfolio")
    public  PortfolioDetails addPortfolio(@Valid @RequestBody DetailsDTO ph)
    {
    	Themes theme = ts.fetchThemesDataByName(ph.getThemeName());
    	  	
		System.out.println(ph.getThemeName());
		System.out.println(theme);

    	
    	PortfolioDetails details = new PortfolioDetails();
    	details.setTheme(theme);
    	details.setPortfolioName(ph.getPortfolioName());
    	details.setExchange(ph.getExchange());
    	details.setBaseCurrency(ph.getBaseCurrency());
    	details.setBenchmark(ph.getBenchmark());
    	details.setCurrentValue(ph.getCurrentValue());
    	details.setFundManagerName(ph.getFundManagerName());
    	details.setInitialInvestment(ph.getInitialInvestment());
    	details.setRebalancingFrequency(ph.getRebalancingFrequency());
    	details.setStatus(ph.getStatus());
    	service.addPortfolio(details);
        return details;

    }
    @GetMapping("/fetchAllportfolio") 
	public ResponseEntity<List<PortfolioDetails>> getAllPortfolioData() {
		List<PortfolioDetails> dataList = service.fetchAllPortfolios();
		return new ResponseEntity<>(dataList, HttpStatus.OK);
	}
    
    @GetMapping("/fetchByName/{portfolioName}")
    public ResponseEntity<PortfolioDetails> getByName(@PathVariable("portfolioName")String portfolioName)
    {
    	PortfolioDetails pd = service.findByName(portfolioName);
    	return new ResponseEntity<>(pd,HttpStatus.OK);
    }
    
    @DeleteMapping(path ="/deletePortfolio/{portfolioName}")
    public ResponseEntity<List<PortfolioDetails>> deletePortfolio(@PathVariable("portfolioName")String portfolioName)
    {
    	service.deletePortfolio(portfolioName);
    	List<PortfolioDetails> portfolios= service.fetchAllPortfolios();
    	return new ResponseEntity<>(portfolios,HttpStatus.OK);

    }
    
    @PutMapping(path ="/editPortfolio/{portfolioName}")
    public PortfolioDetails editPortfolio(@RequestBody PortfolioDetails header,@PathVariable("portfolioName")String portfolioName) 
    {
    	return service.updatePortfolio(header, portfolioName);
    } 
	  
}
