package com.pharma.itsmypharma.model;

import java.math.BigInteger;
import java.util.Date;

import com.pharma.itsmypharma.Entity.User;

public class UserVo {

	public UserVo() {

	}

	private BigInteger userId;

	private String userName;

	private String userEmail;

	private String userPassword;

	private Date insDate;

	private Date lupdDate;

	private String mobileNo;
	
	private Character isAdmin;
	
	private Integer instId;

	public UserVo(User user) {

		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.mobileNo = user.getMobileNo();
		this.userEmail = user.getUserEmail();
		this.isAdmin=user.getIsAdmin();
		
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getInsDate() {
		return insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public Date getLupdDate() {
		return lupdDate;
	}

	public void setLupdDate(Date lupdDate) {
		this.lupdDate = lupdDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Character getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Character isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getInstId() {
		return instId;
	}

	public void setInstId(Integer instId) {
		this.instId = instId;
	}

}
