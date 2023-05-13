package com.usm.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.usm.model.PortfolioComposition;
import com.usm.repository.PortfolioDetailRepo;
import com.usm.service.PortfolioCompositionService;
import com.usm.service.SecurityMasterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Composition")
public class PortfolioCompositionController {

	@Autowired
	PortfolioCompositionService pcs;

	@Autowired
	SecurityMasterService serve;

	@Autowired
	PortfolioDetailRepo repo;

	@PostMapping("/addComposition")
	public ResponseEntity<PortfolioComposition> addComposition(@Valid @RequestBody PortfolioComposition pc) {
		PortfolioComposition portfolio = pcs.addComposition(pc);

		return new ResponseEntity<>(portfolio, HttpStatus.OK);

	}

	@GetMapping("/fetchComposition")
	public ResponseEntity<List<PortfolioComposition>> getAllPortfolioData() {
		List<PortfolioComposition> dataList = pcs.fetchAllCompositionData();
		return new ResponseEntity<>(dataList, HttpStatus.OK);

	}

	@GetMapping("/fetchById/{portfolioCompostionId}")
	public ResponseEntity<PortfolioComposition> getDataByPortfolioCompostionId(
			@PathVariable("portfolioCompostionId") int portfolioCompostionId) {
		PortfolioComposition portfolioComposition = pcs.fetchPortfolioDataById(portfolioCompostionId);
		return new ResponseEntity<>(portfolioComposition, HttpStatus.OK);
	}
	
	@DeleteMapping(path ="/deletePortfolioComposition/{portfolioCompostionId}")
    public ResponseEntity<List<PortfolioComposition>> deletePortfolio(@PathVariable("portfolioCompostionId")int portfolioCompostionId)
    {
    	pcs.deletePortfolioComposittion(portfolioCompostionId);
    	List<PortfolioComposition> portfolios= pcs.fetchAllCompositionData();
    	return new ResponseEntity<>(portfolios,HttpStatus.OK);

    }

	@PutMapping("/update/{portfolioCompostionId}")
	public ResponseEntity<PortfolioComposition> updatePortfolioData(
			@RequestBody PortfolioComposition portfolioComposition,
			@PathVariable("portfolioCompostionId") int portfolioCompostionId) {
		PortfolioComposition updatedComositionData = pcs.updatedComositionData(portfolioCompostionId,
				portfolioComposition);
		return new ResponseEntity<>(updatedComositionData, HttpStatus.OK);

	}
	

}
