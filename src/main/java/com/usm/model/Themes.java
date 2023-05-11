package com.usm.model;

import jakarta.persistence.Entity;


import jakarta.persistence.Id;

@Entity
public class Themes {
	@Id
	private String themeName;
	private String risk;
	private String investmentHorizon;
	private double equities;
	private double fixedIncome;
	private double commodities;
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
	}
	public String getInvestmentHorizon() {
		return investmentHorizon;
	}
	public void setInvestmentHorizon(String investmentHorizon) {
		this.investmentHorizon = investmentHorizon;
	}
	public double getEquities() {
		return equities;
	}
	public void setEquities(double equities) {
		this.equities = equities;
	}
	public double getFixedIncome() {
		return fixedIncome;
	}
	public void setFixedIncome(double fixedIncome) {
		this.fixedIncome = fixedIncome;
	}
	public double getCommodities() {
		return commodities;
	}
	public void setCommodities(double commodities) {
		this.commodities = commodities;
	}
	@Override
	public String toString() {
		return "Themes [themeName=" + themeName + ", risk=" + risk + ", investmentHorizon=" + investmentHorizon
				+ ", equities=" + equities + ", fixedIncome=" + fixedIncome + ", commodities=" + commodities + "]";
	}
	public Themes(String themeName, String risk, String investmentHorizon, double equities, double fixedIncome,
			double commodities) {
		super();
		this.themeName = themeName;
		this.risk = risk;
		this.investmentHorizon = investmentHorizon;
		this.equities = equities;
		this.fixedIncome = fixedIncome;
		this.commodities = commodities;
	}
	public Themes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
