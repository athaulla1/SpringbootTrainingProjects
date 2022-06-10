package com.lntedutech.cxs;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
    private CurrencyExchangeRepository cxrepo;
    
	@Autowired
	private Environment env;  
	
	@GetMapping("/currency-exchange/from/{fromcur}/to/{tocur}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String fromcur,
			@PathVariable String tocur)
	{
	    String port=env.getProperty("local.server.port");
	    
	    CurrencyExchange currencyExchange = cxrepo.findByFromcurrencyAndTocurrency(fromcur, tocur);
	    
	    		//new CurrencyExchange(1000l,fromcur,tocur,BigDecimal.valueOf(85));
		currencyExchange.setEnvironment(port);
	    return currencyExchange;
	}

	@GetMapping("/currency-exchange-HC/from/{fromcur}/to/{tocur}")
	public CurrencyExchange retrieveExchangeValueHC(@PathVariable String fromcur,
			@PathVariable String tocur)
	{
	   String port=env.getProperty("local.server.port");
	    
	    //CurrencyExchange currencyExchange = cxrepo.findByFromcurrencyAndTocurrency(fromcur, tocur);
	    
	    		//new CurrencyExchange(1000l,fromcur,tocur,BigDecimal.valueOf(85));
		//currencyExchange.setEnvironment(port);
	    return new CurrencyExchange(1001l,fromcur,tocur,BigDecimal.valueOf(86),port);
	}

}
