package com.om.priom.microservice.currencyexchangeservice.controller;

import com.om.priom.microservice.currencyexchangeservice.dto.CurrencyExchange;

import com.om.priom.microservice.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
    @Autowired
    private Environment environment;

    @Autowired
    CurrencyExchangeRepository repository;
    @GetMapping("/currency-exchange/{from}/to/{to}")
    public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to){
       // return new CurrencyExchange(1L,from,to,new BigDecimal(100),Integer.parseInt(environment.getProperty("local.server.port")));
        logger.info("retrieveExchangeValue called with {} to {}", from, to);
        CurrencyExchange currencyExchange= repository.findByFromAndTo(from.toUpperCase(), to.toUpperCase());
        if(currencyExchange!=null)
        logger.info("present data in db"+currencyExchange.getId());
        else{
            logger.info("No Data paresent");
        }
        if(currencyExchange ==null) {
            throw new RuntimeException
                    ("Unable to Find data for " + from + " to " + to);
        }

        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
