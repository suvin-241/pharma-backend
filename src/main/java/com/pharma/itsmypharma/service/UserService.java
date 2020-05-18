package com.pharma.itsmypharma.service;

import java.util.List;

import com.pharma.itsmypharma.Entity.User;
import com.pharma.itsmypharma.common.PharmaException;
import com.pharma.itsmypharma.model.UserVo;

public interface UserService {
	
	UserVo createUser(UserVo userVo)throws PharmaException;
	UserVo authUser(UserVo userVo) throws PharmaException;
	List<User> getUserByEmail(UserVo userVo) throws PharmaException;
	List<User> getUserByMobileNo(UserVo userVo) throws PharmaException;
}
