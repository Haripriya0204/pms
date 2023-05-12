package com.usm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usm.dto.DetailsDTO;
import com.usm.model.PortfolioDetails;

import jakarta.validation.Valid;

@Repository
public interface PortfolioDetailRepo extends JpaRepository<PortfolioDetails, String> {

	Optional<PortfolioDetails> findByPortfolioName(String portfolioName);

}
