package com.example.lookgem.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lookgem.model.PinkGem;
import com.example.lookgem.repository.PinkGemRepository;
import org.apache.commons.lang3.StringUtils;

@Repository
public class PinkGemRepositoryImpl implements PinkGemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PinkGem> getPinkGemByCondition(String token, String tokenAddress, int followers,String hasKyc, String hasPump) {
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PinkGem> query = cb.createQuery(PinkGem.class);
        Root<PinkGem> root = query.from(PinkGem.class);
        List<Predicate> predicates = new ArrayList<>();
        
        if (StringUtils.isNotBlank(token)) {
            predicates.add(cb.like(root.get("token"), "%" + token + "%"));
        }
        
        if (StringUtils.isNotBlank(tokenAddress)) {
        	String tokenAddressLower = tokenAddress.toLowerCase();
            predicates.add(cb.like(root.get("tokenAddress"), "%" + tokenAddressLower + "%"));
        }
        
        if (followers > 0) {
        	predicates.add(cb.gt(root.get("followers"), followers));
        }
        
        if (StringUtils.isNotBlank(hasKyc)) {
            predicates.add(cb.equal(root.get("hasKyc"), hasKyc));
        }
        
        if (StringUtils.isNotBlank(hasPump)) {
            predicates.add(cb.equal(root.get("hasPump"), hasPump));
        }
        
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        
        return entityManager.createQuery(query).getResultList();
    }

	@Override
	public List<PinkGem> getPinkGemAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PinkGem> query = cb.createQuery(PinkGem.class);
        Root<PinkGem> root = query.from(PinkGem.class);
        List<Predicate> predicates = new ArrayList<>();
       
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        
        return entityManager.createQuery(query).getResultList();
	}
}
