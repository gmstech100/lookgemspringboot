package com.example.lookgem.repository.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lookgem.model.GemWatch;
import com.example.lookgem.model.PinkGem;
import com.example.lookgem.repository.GemWatchRepository;
import com.example.lookgem.repository.PinkGemRepository;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;

import org.apache.commons.lang3.StringUtils;
import javax.persistence.Query;

@Repository
public class GemWatchRepositoryImpl implements GemWatchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<GemWatch> getGemWatchingByCondition(String token, String tokenAddress, int followers,
            String dateListFrom, String dateListTo, String chain, String hasBscCall, String hasShillSealsCall, String launchPad) {
        String queryString = "SELECT gw FROM GemWatch gw WHERE 1=1";
        if (StringUtils.isNotBlank(token)) {
            queryString += " AND gw.token LIKE :token";
        }
        if (StringUtils.isNotBlank(tokenAddress)) {
            queryString += " AND LOWER(gw.tokenAddress) LIKE :tokenAddress";
        }
        if (followers > 0) {
            queryString += " AND gw.followers >= :followers";
        }
        if (StringUtils.isNotBlank(hasBscCall)) {
            queryString += " AND gw.hasBscCall = :hasBscCall";
        }
        if (StringUtils.isNotBlank(chain)) {
            queryString += " AND gw.chain = :chain";
        }
        if (StringUtils.isNotBlank(hasShillSealsCall)) {
            queryString += " AND gw.hasShillSealsCall = :hasShillSealsCall";
        }
        if (StringUtils.isNotBlank(launchPad)) {
            queryString += " AND gw.launchPad LIKE :launchPad";
        }
        if (StringUtils.isNotBlank(dateListFrom)) {
            queryString += " AND STR_TO_DATE(gw.dateList, '%d%m%Y') >= :fromDate";
        }
        if (StringUtils.isNotBlank(dateListTo)) {
            queryString += " AND STR_TO_DATE(gw.dateList, '%d%m%Y') <= :toDate";
        }
        
        Query query = entityManager.createQuery(queryString);
        
        if (StringUtils.isNotBlank(token)) {
            query.setParameter("token", "%" + token + "%");
        }
        if (StringUtils.isNotBlank(tokenAddress)) {
            query.setParameter("tokenAddress", "%" + tokenAddress.toLowerCase() + "%");
        }
        if (followers > 0) {
            query.setParameter("followers", followers);
        }
        if (StringUtils.isNotBlank(hasBscCall)) {
            query.setParameter("hasBscCall", hasBscCall);
        }
        if (StringUtils.isNotBlank(chain)) {
            query.setParameter("chain", chain);
        }
        if (StringUtils.isNotBlank(hasShillSealsCall)) {
            query.setParameter("hasShillSealsCall", hasShillSealsCall);
        }
        if (StringUtils.isNotBlank(launchPad)) {
            query.setParameter("launchPad", "%" + launchPad + "%");
        }
        if (StringUtils.isNotBlank(dateListFrom)) {
            query.setParameter("fromDate", dateListFrom);
        }
        if (StringUtils.isNotBlank(dateListTo)) {
            query.setParameter("toDate", dateListTo);
        }
        
        return query.getResultList();
    }





	@Override
	public List<GemWatch> getGemWathchingAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GemWatch> query = cb.createQuery(GemWatch.class);
        Root<GemWatch> root = query.from(GemWatch.class);
        List<Predicate> predicates = new ArrayList<>();
       
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        
        return entityManager.createQuery(query).getResultList();
	}
}
