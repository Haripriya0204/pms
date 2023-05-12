package com.usm.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PortfolioComposition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int portfolioCompostionId;
	@DateTimeFormat(style = "yyyy-mm-dd")
	private LocalDate transactionDate;
	@Column(unique=true)
	private String securityName;
	private String equityCategory;
	private String assetClass;
	private String subAssetClass;
	private String exchange;
	private String transactionType;
	private double price;
	private double quantity;
	private double value;
	private double allocation;
	
	@ManyToOne  
	@JoinColumn(name="portfolioName")
	private PortfolioDetails portfoliodetail;
	
	/*
	 * @OneToMany(cascade =
	 * CascadeType.ALL,mappedBy="security",fetch=FetchType.LAZY) private
	 * List<PortfolioComposition> portfoliocomposition;
	 */
	
	
	public int getPortfolioCompostionId() {
		return portfolioCompostionId;
	}
	public void setPortfolioCompostionId(int portfolioCompostionId) {
		this.portfolioCompostionId = portfolioCompostionId;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public String getEquityCategory() {
		return equityCategory;
	}
	public void setEquityCategory(String equityCategory) {
		this.equityCategory = equityCategory;
	}
	public String getAssetClass() {
		return assetClass;
	}
	public void setAssetClass(String assetClass) {
		this.assetClass = assetClass;
	}
	public String getSubAssetClass() {
		return subAssetClass;
	}
	public void setSubAssetClass(String subAssetClass) {
		this.subAssetClass = subAssetClass;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getAllocation() {
		return allocation;
	}
	public void setAllocation(double allocation) {
		this.allocation = allocation;
	}
	
	
	@JsonBackReference
	public PortfolioDetails getPortfoliodetail() {
		return portfoliodetail;
	}
	public void setPortfoliodetail(PortfolioDetails portfoliodetail) {
		this.portfoliodetail = portfoliodetail;
	}
	public PortfolioComposition(int portfolioCompostionId, LocalDate transactionDate, String securityName,
			String equityCategory, String assetClass, String subAssetClass, String exchange, String transactionType,
			double price, double quantity, double value, double allocation, PortfolioDetails portfoliodetail) {
		super();
		this.portfolioCompostionId = portfolioCompostionId;
		this.transactionDate = transactionDate;
		this.securityName = securityName;
		this.equityCategory = equityCategory;
		this.assetClass = assetClass;
		this.subAssetClass = subAssetClass;
		this.exchange = exchange;
		this.transactionType = transactionType;
		this.price = price;
		this.quantity = quantity;
		this.value = value;
		this.allocation = allocation;
		this.portfoliodetail = portfoliodetail;
	}
	public PortfolioComposition() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PortfolioComposition [portfolioCompostionId=" + portfolioCompostionId + ", transactionDate="
				+ transactionDate + ", securityName=" + securityName + ", equityCategory=" + equityCategory
				+ ", assetClass=" + assetClass + ", subAssetClass=" + subAssetClass + ", exchange=" + exchange
				+ ", transactionType=" + transactionType + ", price=" + price + ", quantity=" + quantity + ", value="
				+ value + ", allocation=" + allocation + ", portfoliodetail=" + portfoliodetail + "]";
	}
	
	

}
