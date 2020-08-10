package com.pharma.itsmypharma.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "pharma_customer_mast")
@DynamicInsert
@DynamicUpdate
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "pcm_cust_id")
	private String custId;
	
	@Column(name = "pcm_first_name ")
	private String firstName;
	
	@Column(name = "pcm_last_name")
	private String lastName;
	
	@Column(name = "pcm_otp_offset")
	private String otpOffset;
	
	@Column(name = "pcm_mobile_no")
	private String mobileNo;
	
	@Column(name = "pcm_ins_date")
	@Temporal(TemporalType.DATE)
	private Date insDate;
	
	@Column(name = "pcm_mobile_no")
	@Temporal(TemporalType.DATE)
	private Date lupdDate;
	
	@Column(name = "pcm_whatsapp_enabled")
	private Character whatsappEnabled;
	
	@Column(name = "pcm_sms_enabled")
	private Character smsEnabled;
	
	@Column(name = "pcm_otp_time")
	@Temporal(TemporalType.DATE)
	private Date otpDate;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOtpOffset() {
		return otpOffset;
	}

	public void setOtpOffset(String otpOffset) {
		this.otpOffset = otpOffset;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	public Character getWhatsappEnabled() {
		return whatsappEnabled;
	}

	public void setWhatsappEnabled(Character whatsappEnabled) {
		this.whatsappEnabled = whatsappEnabled;
	}

	public Character getSmsEnabled() {
		return smsEnabled;
	}

	public void setSmsEnabled(Character smsEnabled) {
		this.smsEnabled = smsEnabled;
	}

	public Date getOtpDate() {
		return otpDate;
	}

	public void setOtpDate(Date otpDate) {
		this.otpDate = otpDate;
	}
	
	
	
	 
}
