package com.zs.inheritance.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Billing {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "bill_no")
	private int billNo;
	@Column(length = 15, name = "cust_name")
	private String custName;
	@Column(length = 16, name = "nums")
	private String number;
	
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
