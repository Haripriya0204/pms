
package com.usm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usm.model.StockPrice;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, String> {
	public StockPrice findByIsinNumber(String isinNumber);
}
