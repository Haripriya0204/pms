package com.usm.service;
import java.time.LocalDate;
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
	
	public void deletePortfolioComposittion(int portfolioCompostionId) 
	{
		repo.deleteById(portfolioCompostionId);
	}

	public PortfolioComposition updatedComositionData(int portfolioCompostionId, PortfolioComposition pc) {
		PortfolioComposition composition = repo.findById(portfolioCompostionId).orElseThrow(
				() -> new DataNotFoundException(" Data not found with given portfolio Id:" + portfolioCompostionId));
		composition.setAllocation(pc.getAllocation());
		composition.setAssetClass(pc.getAssetClass());
		composition.setEquityCategory(pc.getEquityCategory());
		composition.setExchange(pc.getExchange());
		composition.setPortfolioCompostionId(pc.getPortfolioCompostionId());
		composition.setPrice(pc.getPrice());
		composition.setQuantity(pc.getQuantity());
		composition.setSecurityName(pc.getSecurityName());
		composition.setSubAssetClass(pc.getSubAssetClass());
		composition.setTransactionDate(LocalDate.now());
		composition.setTransactionType(pc.getTransactionType());
		return repo.save(composition);
	}

}
