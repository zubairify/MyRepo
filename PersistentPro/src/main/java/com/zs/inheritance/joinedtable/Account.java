package com.zs.inheritance.joinedtable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "acnt_billing4")
@PrimaryKeyJoinColumn(name = "bill_no", referencedColumnName = "bill_no")
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
