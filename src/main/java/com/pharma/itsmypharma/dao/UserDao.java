package com.pharma.itsmypharma.dao;

import java.util.List;

import com.pharma.itsmypharma.Entity.User;
import com.pharma.itsmypharma.common.GenericDao;

public interface UserDao extends GenericDao<User> {

	public List<User> getUserByEmail(String email);
	public List<User> getUserByMobileNo(String email);

}
