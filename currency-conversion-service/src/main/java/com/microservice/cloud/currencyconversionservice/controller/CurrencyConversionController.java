package com.microservice.cloud.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Environment env;
	
	@Autowired
	CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean getExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		logger.info("from --> {} To --> {}" , from, to);
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("from", from);
		paramMap.put("to", to);
		
		ConversionBean bean = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
				ConversionBean.class, paramMap).getBody();
		
		ConversionBean ex = new ConversionBean(from,to, bean.getConversionFactor(), quantity, bean.getConversionFactor().multiply(quantity), 
				Integer.parseInt(env.getProperty("local.server.port")));
		return ex;
		
	}
	
	@GetMapping("/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean getExchangeValueFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		logger.info("from --> {} To --> {}" , from, to);
		ConversionBean bean = proxy.getExchangeValue(from, to);
		
		ConversionBean ex = new ConversionBean(from,to, bean.getConversionFactor(), quantity, bean.getConversionFactor().multiply(quantity), 
			bean.getPort());
		logger.info("Return from method getExchangeValueFeign()......");
		return ex;
		
	}

}
