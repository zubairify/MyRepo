package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "heroes")
public class Hero {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 20)
	private String power;
	
	@Column(length = 10)
	private String universe;
	
	@Column(length = 20)
	private String strength;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}

	public String getUniverse() {
		return universe;
	}
	public void setUniverse(String universe) {
		this.universe = universe;
	}

	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
}
