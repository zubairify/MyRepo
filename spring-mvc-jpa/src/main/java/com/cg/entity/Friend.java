package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "friendz")
@SequenceGenerator(name = "frseq", sequenceName = "seq_frnd", initialValue = 121)
public class Friend {
	@Id
	@GeneratedValue(generator = "frseq", strategy = GenerationType.SEQUENCE)
	private int frid;

	@Column(length = 25)
	private String name;
	private int age;
	@Column(length = 10)
	private String gender;
	@Column(length = 15)
	private String city;
	
	public int getFrid() {
		return frid;
	}
	public void setFrid(int frid) {
		this.frid = frid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
