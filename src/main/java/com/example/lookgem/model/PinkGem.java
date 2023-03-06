package com.example.lookgem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pink_gem")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class PinkGem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "token")
    private String token;

    @NotBlank
    @Column(name = "token_address")
    private String tokenAddress;
    
    @Column(name = "followers")
    private int followers;
    
    @Column(name = "has_kyc")
    private String hasKyc;
    
    @Column(name = "has_pump")
    private String hasPump;

}
