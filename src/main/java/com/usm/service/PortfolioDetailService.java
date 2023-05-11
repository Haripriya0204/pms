package com.usm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usm.exception.DataNotFoundException;
import com.usm.model.PortfolioComposition;
import com.usm.model.PortfolioDetails;
import com.usm.repository.PortfolioCompositionRepo;
import com.usm.repository.PortfolioDetailRepo;

import jakarta.validation.Valid;

@Service
public class PortfolioDetailService {
	
	@Autowired
	PortfolioDetailRepo repo;
	
	public PortfolioDetails addPortfolio(@Valid PortfolioDetails ph) {
		
		return repo.save(ph);
	}

	public List<PortfolioDetails> fetchAllMasterData() {
		return repo.findAll();
	}	

	public PortfolioDetails findByName(String portfolioName) {
		Optional<PortfolioDetails> dataOptional = repo.findByPortfolioName(portfolioName);
		if (dataOptional.isPresent()) {
			return dataOptional.get();
		} else {
			throw new DataNotFoundException("Id is not valid");
		}
	}

	
}