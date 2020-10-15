package com.zs.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "acnt_billing2")
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
