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
@Table(name = "gem_watch")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class GemWatch {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "token")
    private String token;

    @NotBlank
    @Column(name = "token_address")
    private String tokenAddress;
    
    @Column(name = "twitter")
    private String twitter;
    
    @Column(name = "followers")
    private int followers;
    
    @Column(name = "telegram")
    private String telegram;
    
    @Column(name = "website")
    private String website;
    
    @Column(name = "date_list")
    private String dateList;
    
    @Column(name = "chain")
    private String chain;
    
    @Column(name = "has_bsc_call")
    private String hasBscCall;
    
    @Column(name = "has_shillseals_call")
    private String hasShillSealsCall;
    
    @Column(name = "launch_pad")
    private String launchPad;

}
