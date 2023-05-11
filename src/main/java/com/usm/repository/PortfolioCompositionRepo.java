package com.usm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.usm.model.PortfolioComposition;


@Repository
public interface PortfolioCompositionRepo extends JpaRepository<PortfolioComposition, Integer> {

}
