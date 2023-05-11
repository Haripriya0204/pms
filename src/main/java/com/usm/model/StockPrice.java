
package com.usm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StockPrice")
public class StockPrice {

	private String symbol;
	private String series;
	private String last;
	private String close;
	private String timeStamp;
	@Id
	private String isinNumber;
	public StockPrice(String symbol, String series, String last, String close, String timeStamp, String isinNumber) {
		super();
		this.symbol = symbol;
		this.series = series;
		this.last = last;
		this.close = close;
		this.timeStamp = timeStamp;
		this.isinNumber = isinNumber;
	}
	public StockPrice() {
		super();
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getIsinNumber() {
		return isinNumber;
	}
	public void setIsinNumber(String isinNumber) {
		this.isinNumber = isinNumber;
	}
	
}
