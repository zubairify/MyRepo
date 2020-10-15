package com.zs.inheritance.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "card_billing1")
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
