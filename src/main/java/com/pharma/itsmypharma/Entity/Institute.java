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

import com.pharma.itsmypharma.model.UserVo;

@Entity
@Table(name = "pharma_inst_mast")
@DynamicInsert
@DynamicUpdate
public class Institute implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name ="pim_inst_id")
	private Integer instId;
	
	@Column(name="pim_mobile_no")
	private String mobileNo;
	
	@Column(name="pim_email_id")
	private String email;
	
	@Column(name="pim_done_flag")
	private Character doneFlag;
	
	@Temporal(TemporalType.DATE)
	@Column(name="pim_ins_date")
	private Date insDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="pim_ludp_date")
	private Date lupdDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="pim_expiry_date")	
	private Date expDate;

	
	public Institute() {
		super();
	}
	public Institute(UserVo userVo) {
		this.mobileNo=userVo.getMobileNo();
		this.email=userVo.getUserEmail();
		
	}
	public Integer getInstId() {
		return instId;
	}

	public void setInstId(Integer instId) {
		this.instId = instId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getDoneFlag() {
		return doneFlag;
	}

	public void setDoneFlag(Character doneFlag) {
		this.doneFlag = doneFlag;
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

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
