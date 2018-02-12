package com.microservice.cloud.currencyconversionservice.controller;

import java.math.BigDecimal;

public class ConversionBean {
	
	private String to;
	private String from;
	private BigDecimal conversionFactor;
	private BigDecimal quantity;
	private BigDecimal calculatedValue;
	private int port;
	
	public ConversionBean() {
		super();
	}
	
	public ConversionBean(String from, String to, BigDecimal conversionFactor, BigDecimal quantity,
			BigDecimal calculatedValue, int port) {
		super();
		this.to = to;
		this.from = from;
		this.conversionFactor = conversionFactor;
		this.quantity = quantity;
		this.calculatedValue = calculatedValue;
		this.port = port;
	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getCalculatedValue() {
		return calculatedValue;
	}
	public void setCalculatedValue(BigDecimal calculatedValue) {
		this.calculatedValue = calculatedValue;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	

}
