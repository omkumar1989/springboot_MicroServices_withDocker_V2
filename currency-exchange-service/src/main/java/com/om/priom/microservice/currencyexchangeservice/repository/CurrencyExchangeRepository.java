package com.om.priom.microservice.currencyexchangeservice.repository;

import com.om.priom.microservice.currencyexchangeservice.dto.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Integer> {

    CurrencyExchange findByFromAndTo(String from, String to);
}
