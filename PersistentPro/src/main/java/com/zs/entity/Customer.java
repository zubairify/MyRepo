package com.zs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@SequenceGenerator(name = "cseq", sequenceName = "cust_seq", allocationSize = 1)
@NamedQuery(name = "highlimit", query = "FROM Customer WHERE creditLimit >= :crl")
@NamedNativeQuery(name = "sql", query = "SELECT * FROM customers WHERE cr_limit<5000")
public class Customer {
	@Id
	@GeneratedValue(generator = "cseq", strategy = GenerationType.SEQUENCE)
	@Column(name = "cust_id")
	private int custId;
	@Column(name = "cname", length = 20)
	private String custName;
	@Column(length = 15)
	private String city;
	@Column(name = "cr_limit")
	private double creditLimit;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
}
