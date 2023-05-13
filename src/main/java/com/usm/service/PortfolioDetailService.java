package com.usm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usm.dto.DetailsDTO;
import com.usm.exception.DataNotFoundException;
import com.usm.model.PortfolioDetails;
import com.usm.repository.PortfolioDetailRepo;

import jakarta.validation.Valid;

@Service
public class PortfolioDetailService {
	
	@Autowired
	PortfolioDetailRepo repo;
	
	public PortfolioDetails addPortfolio(@Valid PortfolioDetails ph) {
		
		return repo.save(ph);
	}

	public List<PortfolioDetails> fetchAllPortfolios() {
		return repo.findAll();
	}	

	public PortfolioDetails findByName(String portfolioName) 
	{
		Optional<PortfolioDetails> dataOptional = repo.findByPortfolioName(portfolioName);
		if (dataOptional.isPresent()) 
		{
			return dataOptional.get();
		} 
		else 
		{
			throw new DataNotFoundException("Id is not valid");
		}
	}

	public void deletePortfolio(String portfolioName) 
	{
		repo.deleteById(portfolioName);
	}

	public PortfolioDetails updatePortfolio(PortfolioDetails header, String portfolioName) 
	{
		PortfolioDetails oldHeader=repo.findByPortfolioName(portfolioName).orElseThrow(
				()->new DataNotFoundException(" Data not found with given portfolioName:"+portfolioName));
		oldHeader.setPortfolioName(header.getPortfolioName());
		oldHeader.setBaseCurrency(header.getBaseCurrency());
		oldHeader.setBenchmark(header.getBenchmark());
		oldHeader.setExchange(header.getExchange());
		oldHeader.setRebalancingFrequency(header.getRebalancingFrequency());
		oldHeader.setFundManagerName(header.getFundManagerName());
		oldHeader.setInitialInvestment(header.getInitialInvestment());
		oldHeader.setCurrentValue(header.getCurrentValue());
		oldHeader.setStatus(header.getStatus());
		return repo.save(oldHeader);
	}

	
}