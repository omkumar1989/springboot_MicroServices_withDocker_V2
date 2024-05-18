package com.om.priom.microservice.currencyconversionservice.proxy;

import com.om.priom.microservice.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange-service")//loadBanlanceing from eureka server
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to);

}
