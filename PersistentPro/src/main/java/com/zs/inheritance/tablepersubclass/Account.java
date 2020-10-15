package com.zs.inheritance.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "acnt_billing1")
public class Account extends Billing {
	
	@Column(length = 15, name = "bank_name")
	private String bankName;

	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
