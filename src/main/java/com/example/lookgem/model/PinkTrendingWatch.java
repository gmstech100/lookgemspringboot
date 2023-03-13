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
@Table(name = "pink_trending_watch")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class PinkTrendingWatch {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "token")
    private String token;
    
    @Column(name = "symbol")
    private String symbol;
    
    @Column(name = "pinksale_address")
    private String pinksaleAddress;

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
    
    @Column(name = "type_launch")
    private String typeLaunch;
    
    @Column(name = "chain")
    private String chain;
    
    @Column(name = "soft_cap")
    private String softCap;
    
    @Column(name = "hard_cap")
    private String hardCap;
    
    @Column(name = "start_time")
    private String startTime;
    
    @Column(name = "end_time")
    private String endTime;
    
    @Column(name = "liquidity_percentage")
    private Integer liquidityPercentage;
    
    @Column(name = "liquidity_lock_duration")
    private Integer  liquidityLockDuration;
    
    @Column(name = "kyc")
    private String hasKyc;
    
    @Column(name = "audit")
    private String hasAudit;
    
    @Column(name = "safu")
    private String hasSafu;
    
    @Column(name = "pool_details")
    private String poolDetails;
    
    @Column(name = "kyc_details")
    private String kycDetails;
    
    @Column(name = "min")
    private String min;
    
    @Column(name = "max")
    private String  max;

}
