package com.pharma.itsmypharma.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pharma.itsmypharma.Entity.User;
import com.pharma.itsmypharma.common.GenericDaoImpl;
import com.pharma.itsmypharma.common.QueryConstants;
import com.pharma.itsmypharma.dao.UserDao;

@Repository
@SuppressWarnings("unchecked")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{
	
	  private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

	    public UserDaoImpl() {
	        super(User.class);
	    }
	   @Override
	    public List<User> getUserByEmail(String email) {
		   LOGGER.info("query {}", QueryConstants.getQuery(QueryConstants.GET_BY_EMAIL));
	        Query query = getEntityManager()
	                .createQuery(QueryConstants.getQuery(QueryConstants.GET_BY_EMAIL));
	        LOGGER.info("query {}", QueryConstants.getQuery(QueryConstants.GET_BY_EMAIL));
	        query.setParameter(QueryConstants.ARG1, email);
	        return query.getResultList();
	    }
	@Override
	public List<User> getUserByMobileNo(String mobileNo) {
		 Query query = getEntityManager()
	                .createQuery(QueryConstants.getQuery(QueryConstants.GET_BY_MOBILE_NO));
	        LOGGER.info("query {}", QueryConstants.getQuery(QueryConstants.GET_BY_MOBILE_NO));
	        query.setParameter(QueryConstants.ARG1, mobileNo);
	        return query.getResultList();
	}



}
