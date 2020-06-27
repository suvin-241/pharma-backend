package com.pharma.itsmypharma.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharma.itsmypharma.Entity.Institute;
import com.pharma.itsmypharma.Entity.User;
import com.pharma.itsmypharma.common.PharmaException;
import com.pharma.itsmypharma.common.ResourceBundleConstants;
import com.pharma.itsmypharma.dao.InstituteDao;
import com.pharma.itsmypharma.dao.UserDao;
import com.pharma.itsmypharma.model.UserVo;
import com.pharma.itsmypharma.service.UserService;
import com.pharma.itsmypharma.util.PharmaConstants;
import com.pharma.itsmypharma.util.PharmaResourceBundle;
import com.pharma.itsmypharma.util.PharmaUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private InstituteDao instDao;

	@Override
	@Transactional
	public UserVo createUser(UserVo userVo) throws PharmaException {

		
		List<User> userList=getUserByEmail(userVo);
		if(userList!=null && !userList.isEmpty()) {
			throw new PharmaException(PharmaResourceBundle.getProperty(ResourceBundleConstants.EMAIL_EXISTS));
		}
		userList=getUserByMobileNo(userVo);
		if(userList!=null&&!userList.isEmpty()) {
			throw new PharmaException(PharmaResourceBundle.getProperty(ResourceBundleConstants.MOBILE_EXISTS));
		}
		
		Institute inst=new Institute(userVo);
		inst.setDoneFlag(PharmaConstants.NO);
		inst.setInsDate(new Date());
		inst.setLupdDate(new Date());
		inst=instDao.save(inst);
		
		User user = new User(userVo);
		user.setUserPassword(PharmaUtil.encrypt(userVo.getUserPassword()));
		user.setUserName(userVo.getUserEmail());
		user.setInsDate(new Date());
		user.setLupdDate(new Date());
		user.setIsAdmin(PharmaConstants.YES);
		user.setInstitute(inst);
		User customer = userDao.save(user);
		UserVo vo=new UserVo(customer);
		vo.setInstId(inst.getInstId());
		return  vo;

	}

	@Override
	public UserVo authUser(UserVo userVo)throws PharmaException {

		List<User> userList=getUserByEmail(userVo);
		if(userList==null || userList.isEmpty()) {
			throw new PharmaException(PharmaResourceBundle.getProperty(ResourceBundleConstants.USER_NOT_FOUND));
		}
		if(!(PharmaUtil.encrypt(userVo.getUserPassword())).equals(userList.get(0).getUserPassword())) {
			throw new PharmaException(PharmaResourceBundle.getProperty(ResourceBundleConstants.INVALID_PASSWORD));
		}
		return new UserVo(userList.get(0));
	}

	@Override
	public List<User> getUserByEmail(UserVo userVo) throws PharmaException {

		List<User> userList = userDao.getUserByEmail(userVo.getUserEmail().toLowerCase());
		return userList;
	}

	@Override
	public List<User> getUserByMobileNo(UserVo userVo) throws PharmaException {
		List<User> userList = userDao.getUserByMobileNo(userVo.getMobileNo());
		return userList;

	}

}
