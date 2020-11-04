package com.cg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Universe {
	@Id
	private int uid;
	
	@Column(length = 10)
	private String uname;
	
	@OneToMany(mappedBy = "universe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Hero> heroes = new ArrayList<Hero>();

	public Universe() {
	}
	
	@Override
	public String toString() {
		return "{\"uid\":" + uid + ",\"uname\":\"" + uname + "\"}";
	}

	public Universe(int uid, String uname) {
		this.uid = uid;
		this.uname = uname;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}

	public List<Hero> getHeroes() {
		return heroes;
	}
	public void setHeroes(List<Hero> heroes) {
		this.heroes = heroes;
	}
}
