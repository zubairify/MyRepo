package com.zs.one2one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 30)
	private String street;
	@Column(length = 15)
	private String city;
	@Column(length = 7)
	private String pincode;
	@Transient
	private String landmark;
	
	@OneToOne
	@JoinColumn(name = "pid")
	private Person p;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
}
