package com.microservice.cloud.currencyexchangeservice.controller;

import java.math.BigDecimal;

public class ExchangeValue {
	
	private String from;
	private String to;
	private BigDecimal conversionFactor;
	private int port;
	
	public ExchangeValue(String from, String to, BigDecimal conversionFactor) {
		super();
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
	}
	
	public int getPort() {
		return port;
	}



	public void setPort(int port) {
		this.port = port;
	}



	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	
	
	

}
