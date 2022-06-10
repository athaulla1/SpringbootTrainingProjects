package com.lntedutech.cxs;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {
	
	@Id
	private Long id;
	private String fromcurrency;
	private String tocurrency;
	private BigDecimal conversionrate;
	private String environment;
	
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
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
	public BigDecimal getConversionrate() {
		return conversionrate;
	}
	public void setConversionrate(BigDecimal conversionrate) {
		this.conversionrate = conversionrate;
	}
	
	public CurrencyExchange() {
		super();
	}
	public CurrencyExchange(Long id, String fromcurrency, String tocurrency, BigDecimal conversionrate,
			String environment) {
		super();
		this.id = id;
		this.fromcurrency = fromcurrency;
		this.tocurrency = tocurrency;
		this.conversionrate = conversionrate;
		this.environment = environment;
	}
		
}

	
