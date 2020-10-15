package com.zs.pojo;

public class PartCustomer {
	private String custName;
	private double creditLimit;
	
	public PartCustomer() {
	}

	public PartCustomer(String custName, double creditLimit) {
		this.custName = custName;
		this.creditLimit = creditLimit;
	}

	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}

	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
}
