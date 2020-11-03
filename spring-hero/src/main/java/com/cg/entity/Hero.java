package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(length = 20)
	private String strength;
	
	@Transient
	private int uid;
	
	@ManyToOne
	@JoinColumn(name = "uid")
	@JsonIgnore
	private Universe universe;

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

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public Universe getUniverse() {
		return universe;
	}
	public void setUniverse(Universe universe) {
		this.universe = universe;
	}

	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
}
