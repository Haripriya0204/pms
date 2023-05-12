package com.usm.dto;

public class DetailsDTO {

	private String portfolioName;
	private String baseCurrency;
	private String exchange;
	private String benchmark;
	
	
	private String fundManagerName;
	private double initialInvestment;
	private double currentValue;
	private String rebalancingFrequency;
	private String status;
	private String themeName;
	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getBenchmark() {
		return benchmark;
	}
	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}
	public String getFundManagerName() {
		return fundManagerName;
	}
	public void setFundManagerName(String fundManagerName) {
		this.fundManagerName = fundManagerName;
	}
	public double getInitialInvestment() {
		return initialInvestment;
	}
	public void setInitialInvestment(double initialInvestment) {
		this.initialInvestment = initialInvestment;
	}
	public double getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	public String getRebalancingFrequency() {
		return rebalancingFrequency;
	}
	public void setRebalancingFrequency(String rebalancingFrequency) {
		this.rebalancingFrequency = rebalancingFrequency;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	
}
