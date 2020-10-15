package com.zs.inheritance.joinedtable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "card_billing4")
@PrimaryKeyJoinColumn(name = "bill_no", referencedColumnName = "bill_no")
public class Card extends Billing {
	
	@Column(length = 10, name = "card_type")
	private String cardType;

	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
