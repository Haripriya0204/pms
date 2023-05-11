package com.usm.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Portfolio Details")
public class PortfolioDetails 
{
	@Id
	@Column(unique=true)
	private String portfolioName;
	private String baseCurrency;
	private String exchange;
	private String benchmark;
	
	
	private String fundManagerName;
	private double initialInvestment;
	private double currentValue;
	private String rebalancingFrequency;
	private String status;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ThemeName",referencedColumnName="themeName")
    private Themes theme;

	@OneToMany(cascade = CascadeType.ALL,mappedBy="portfoliodetail",fetch=FetchType.LAZY)
	private List<PortfolioComposition> portfoliocomposition;

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

	public Themes getTheme() {
		return theme;
	}

	public void setTheme(Themes theme) {
		this.theme = theme;
	}
	
	@JsonManagedReference
	public List<PortfolioComposition> getPortfoliocomposition() {
		return portfoliocomposition;
	}

	public void setPortfoliocomposition(List<PortfolioComposition> portfoliocomposition) {
		this.portfoliocomposition = portfoliocomposition;
	}

	public PortfolioDetails(String portfolioName, String baseCurrency, String exchange, String benchmark,
			String fundManagerName, double initialInvestment, double currentValue, String rebalancingFrequency,
			String status, Themes theme, List<PortfolioComposition> portfoliocomposition) {
		super();
		this.portfolioName = portfolioName;
		this.baseCurrency = baseCurrency;
		this.exchange = exchange;
		this.benchmark = benchmark;
		this.fundManagerName = fundManagerName;
		this.initialInvestment = initialInvestment;
		this.currentValue = currentValue;
		this.rebalancingFrequency = rebalancingFrequency;
		this.status = status;
		this.theme = theme;
		this.portfoliocomposition = portfoliocomposition;
	}

	@Override
	public String toString() {
		return "PortfolioDetails [portfolioName=" + portfolioName + ", baseCurrency=" + baseCurrency + ", exchange="
				+ exchange + ", benchmark=" + benchmark + ", fundManagerName=" + fundManagerName
				+ ", initialInvestment=" + initialInvestment + ", currentValue=" + currentValue
				+ ", rebalancingFrequency=" + rebalancingFrequency + ", status=" + status + ", theme=" + theme
				+ ", portfoliocomposition=" + portfoliocomposition + "]";
	}

	public PortfolioDetails() {
		super();
	}

	
	
}
