package com.example.lookgem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coingecko_new_currency")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class CoingeckoNewCurrency {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "token")
    private String token;
    
    @Column(name = "symbol")
    private String symbol;

    @Column(name = "token_address")
    private String tokenAddress;
    
    @Column(name = "twitter")
    private String twitter;
    
    @Column(name = "followers")
    private Integer followers;
    
    @Column(name = "telegram")
    private String telegram;
    
    @Column(name = "website")
    private String website;
    
    @Column(name = "chain")
    private String chain;
    
    @Column(name = "image")
    private String image;
    
    @Column(name = "description")
    private String description;
}
