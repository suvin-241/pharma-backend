package com.pharma.itsmypharma.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.pharma.itsmypharma.model.UserVo;

@Entity
@Table(name = "pharma_user_mast")
@DynamicInsert
@DynamicUpdate
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "pum_user_id")
	private BigInteger userId;

	@Column(name = "pum_user_name")
	private String userName;

	@Column(name = "pum_user_email")
	private String userEmail;

	@Column(name = "pum_mobile_no")
	private String mobileNo;

	@Column(name = "pum_user_pass")
	private String userPassword;

	@Column(name = "pcm_ins_date")
	@Temporal(TemporalType.DATE)
	private Date insDate;

	@Column(name = "pcm_lupd_date")
	@Temporal(TemporalType.DATE)
	private Date lupdDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="pcm_inst_id")
	private Institute institute;
	
	@Column(name="pum_admin_flag")
	private Character isAdmin;
	public User() {

	}

	public User(UserVo userVo) {
		this.userName = userVo.getUserName();
		this.userEmail = userVo.getUserEmail().toLowerCase();
		this.mobileNo = userVo.getMobileNo();
		

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

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Character getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Character isAdmin) {
		this.isAdmin = isAdmin;
	}
	

}
