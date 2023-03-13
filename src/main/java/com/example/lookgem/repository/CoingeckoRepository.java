package com.example.lookgem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lookgem.model.CoingeckoNewCurrency;

public interface CoingeckoRepository extends JpaRepository<CoingeckoNewCurrency, Long> {

}
