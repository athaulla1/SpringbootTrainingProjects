package com.lntedutech.ccs;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private Long id;
	private String fromcurrency;
	private String tocurrency;
	private BigDecimal quantity;
	private BigDecimal conversionrate;
	private BigDecimal totalCalcAmount;
	private String environment;
	
	
	public CurrencyConversion() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFromcurrency() {
		return fromcurrency;
	}


	public void setFromcurrency(String fromcurrency) {
		this.fromcurrency = fromcurrency;
	}


	public String getTocurrency() {
		return tocurrency;
	}


	public void setTocurrency(String tocurrency) {
		this.tocurrency = tocurrency;
	}


	public BigDecimal getQuantity() {
		return quantity;
	}


	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getConversionrate() {
		return conversionrate;
	}


	public void setConversionrate(BigDecimal conversionrate) {
		this.conversionrate = conversionrate;
	}


	public BigDecimal getTotalCalcAmount() {
		return totalCalcAmount;
	}


	public void setTotalCalcAmount(BigDecimal totalCalcAmount) {
		this.totalCalcAmount = totalCalcAmount;
	}


	public String getEnvironment() {
		return environment;
	}


	public void setEnvironment(String environment) {
		this.environment = environment;
	}


	public CurrencyConversion(Long id, String fromcurrency, String tocurrency, BigDecimal quantity,
			BigDecimal conversionrate, BigDecimal totalCalcAmount, String environment) {
		super();
		this.id = id;
		this.fromcurrency = fromcurrency;
		this.tocurrency = tocurrency;
		this.quantity = quantity;
		this.conversionrate = conversionrate;
		this.totalCalcAmount = totalCalcAmount;
		this.environment = environment;
	}
	
	
}
