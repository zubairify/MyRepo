package com.zs.jointable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "magazine")
@SecondaryTable(name = "mag_misc")
public class Magazine {
	@Id
	@GeneratedValue
	private int magId;
	@Column(length = 20)
	private String name;
	private double price;
	
	@Column(length = 12, table = "mag_misc")
	private String isbn;
	@Column(length = 15, table = "mag_misc")
	private String publisher;
	
	public int getMagId() {
		return magId;
	}
	public void setMagId(int magId) {
		this.magId = magId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
