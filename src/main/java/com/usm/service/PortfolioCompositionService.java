package com.usm.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usm.exception.DataNotFoundException;
import com.usm.model.PortfolioComposition;
import com.usm.repository.PortfolioCompositionRepo;

import jakarta.validation.Valid;


@Service
public class PortfolioCompositionService {
	
	@Autowired
	PortfolioCompositionRepo repo;

	public PortfolioComposition addComposition(@Valid PortfolioComposition pc) {
		
		return repo.save(pc);
	}

	public List<PortfolioComposition> fetchAllCompositionData() {
		return repo.findAll();
	}

	public PortfolioComposition fetchPortfolioDataById(int portfolioCompostionId) {
		Optional<PortfolioComposition> dataOptional = repo.findById(portfolioCompostionId);
		if (dataOptional.isPresent()) {
			return dataOptional.get();
		} else {
			throw new DataNotFoundException("Composition Id  is not valid");
		}
	}

	public PortfolioComposition updatedComositionData(int portfolioCompostionId,
			PortfolioComposition portfolioComposition) {
		
		PortfolioComposition pcs = repo.findById(portfolioCompostionId).orElseThrow(
				()-> new DataNotFoundException("Data is not available with this portfolioId: "+ portfolioCompostionId));
		 pcs.setTransactionDate(portfolioComposition.getTransactionDate());
		 pcs.setSecurityName(portfolioComposition.getSecurityName());
		 pcs.setEquityCategory(portfolioComposition.getEquityCategory());
		 pcs.setAssetClass(portfolioComposition.getAssetClass());
		 pcs.setSubAssetClass(portfolioComposition.getSubAssetClass());
		 pcs.setExchange(portfolioComposition.getExchange());
		 pcs.setTransactionType(portfolioComposition.getSubAssetClass());
		 pcs.setSubAssetClass(portfolioComposition.getSubAssetClass());
		 pcs.setExchange(portfolioComposition.getExchange());
		 pcs.setTransactionType(portfolioComposition.getTransactionType());
		 pcs.setPrice(portfolioComposition.getPrice());
		 pcs.setQuantity(portfolioComposition.getQuantity());
		 pcs.setValue(portfolioComposition.getValue());
		 pcs.setAllocation(portfolioComposition.getAllocation());
		return repo.save(pcs);
	}
	
	/*
	 * @PostMapping("/getComposition/{symbol}/{quantity}") public
	 * ResponseEntity<PortfolioComposition> getComposition(@PathVariable String
	 * symbol,
	 * 
	 * @PathVariable double quantity) {
	 * 
	 * SecurityMaster obj = serve.fetchMasterDataBySymbol(symbol);
	 * PortfolioComposition portfolio = new PortfolioComposition();
	 * portfolio.setSecurityName(obj.getNameOfCompany());
	 * portfolio.setEquityCategory(obj.getSeries());
	 * portfolio.setExchange(obj.getExchange());
	 * portfolio.setPrice(Double.parseDouble(obj.getLastPrice()));
	 * portfolio.setTransactionType(obj.getIndustry());
	 * portfolio.setTransactionDate(LocalDate.now());
	 * portfolio.setQuantity(quantity);
	 * portfolio.setValue(Double.parseDouble(obj.getLastPrice()) * quantity);
	 * 
	 * return new ResponseEntity<>(portfolio, HttpStatus.OK);
	 * 
	 * }
	 */


	
	
	
	
	
	
}
