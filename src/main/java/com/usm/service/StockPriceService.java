package com.usm.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usm.model.StockPrice;
import com.usm.repository.StockPriceRepository;

@Service
public class StockPriceService {
	@Autowired
	private StockPriceRepository repository;
	
	
	public void saveStockDataInDb() throws IOException {
		String line = "";
		StockPrice stock=new StockPrice();
		FileReader fr = new FileReader("src/main/resources/price.csv");
		BufferedReader br = new BufferedReader(fr);
		try {

			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				stock.setSymbol(data[0]);
				stock.setSeries(data[1]);
				stock.setLast(data[2]);
				stock.setClose(data[3]);
				stock.setTimeStamp(data[4]);
				stock.setIsinNumber(data[5]);
				
				repository.save(stock);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}

	}
	
	
}
