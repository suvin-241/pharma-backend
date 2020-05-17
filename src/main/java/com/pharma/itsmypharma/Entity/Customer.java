package com.pharma.itsmypharma.Entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.pharma.itsmypharma.model.CustomerVo;





@Entity
@Table(name = "pharma_cust_mast")
@DynamicInsert
@DynamicUpdate
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name ="pcm_cust_id")
	private BigInteger customerId;
	
	@Column(name = "pcm_cust_name")
	private String custName;
	
	
	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public Customer(CustomerVo vo) {
		this.custName=vo.getCustName();
		
	}


	public BigInteger getCustomerId() {
		return customerId;
	}


	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}






}
