package com.usm.service;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usm.exception.DataNotFoundException;
import com.usm.model.SecurityMaster;
import com.usm.model.StockPrice;
import com.usm.repository.SecurityMasterRepository;
import com.usm.repository.StockPriceRepository;

@Service
public class SecurityMasterService {

	@Autowired
	private SecurityMasterRepository repo;
	
	@Autowired
	private StockPriceRepository repository;

	
	public void saveMasterDataInDb() throws IOException {
		String line = "";
		SecurityMaster master = new SecurityMaster();
		FileReader fr = new FileReader("src/main/resources/nseStocks.csv");
		BufferedReader br = new BufferedReader(fr);
		try {

			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				master.setExchange(data[0]);
				master.setCountry(data[1]);
				master.setCurrency(data[2]);
				master.setIsinNumber(data[3]);
				master.setSymbol(data[4]);
				master.setNameOfCompany(data[5]);
				master.setSeries(data[6]);
				master.setSector(data[7]);
				master.setIndustry(data[8]);
				master.setGics(data[9]);
				master.setAssetClass(data[10]);
				master.setSubAssetClass(data[11]);
				master.setEquity(data[12]);
				StockPrice stock=repository.findByIsinNumber(master.getIsinNumber());
				if(stock!=null) {
					master.setLastPrice(stock.getLast());
					master.setClosePrice(stock.getClose());
				}
				
				repo.save(master);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}

	}

	public List<SecurityMaster> fetchAllMasterData() {
		return repo.findAll();
	}

	public SecurityMaster fetchMasterDataByIsin(String isinNumber) {

		Optional<SecurityMaster> dataOptional = repo.findByIsinNumber(isinNumber);
		if (dataOptional.isPresent()) {
			return dataOptional.get();
		} else {
			throw new DataNotFoundException("ISIN is not valid");
		}

	}

	public List<SecurityMaster> fetchMasterDataBySector(String sector) {

		return repo.findBySectorContaining(sector);

	}

	public SecurityMaster fetchMasterDataBySymbol(String symbol) {
		Optional<SecurityMaster> dataOptional = repo.findBySymbol(symbol);
		if (dataOptional.isPresent()) {
			return dataOptional.get();
		} else {
			throw new DataNotFoundException("Please Provide valid symbol");
		}

	}

	public void deleteStockData(String isinNumber) {
		repo.deleteById(isinNumber);
	}

	public SecurityMaster updateStockData(String isinNumber,SecurityMaster masterData) {
		SecurityMaster dataMaster=repo.findById(isinNumber).orElseThrow(
				()-> new DataNotFoundException("Master Data not found with given isinNumber:"+isinNumber));
	dataMaster.setExchange(masterData.getExchange());
	dataMaster.setCountry(masterData.getCountry());
	dataMaster.setCurrency(masterData.getCurrency());
	dataMaster.setIsinNumber(masterData.getIsinNumber());
	dataMaster.setSymbol(masterData.getSymbol());
	dataMaster.setNameOfCompany(masterData.getNameOfCompany());
	dataMaster.setSeries(masterData.getSeries());
	dataMaster.setSector(masterData.getSector());
	dataMaster.setIndustry(masterData.getIndustry());
	dataMaster.setGics(masterData.getGics());
	dataMaster.setClosePrice(masterData.getClosePrice());
	dataMaster.setLastPrice(masterData.getLastPrice());
	
	 return repo.save(dataMaster);
	}

	public SecurityMaster fetchMasterDataByName(String nameOfCompany) {
		Optional<SecurityMaster> dataOptional = repo.findByNameOfCompany(nameOfCompany);
		if (dataOptional.isPresent()) {
			return dataOptional.get();
		} else {
			throw new DataNotFoundException("Name is invalid");
		}
	}

}
