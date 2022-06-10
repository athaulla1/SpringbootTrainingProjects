package com.lntedutech.cxs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {
	
	public CurrencyExchange findByFromcurrencyAndTocurrency(String a,String b);

}
