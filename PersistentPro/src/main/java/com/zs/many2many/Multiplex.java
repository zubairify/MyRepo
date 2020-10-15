package com.zs.many2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "mulseq", sequenceName = "seq_mpex", initialValue = 1001)
public class Multiplex {
	@Id
	@GeneratedValue(generator = "mulseq", strategy = GenerationType.SEQUENCE)
	@Column(name = "mpex_id")
	private int mpexid;
	@Column(length = 20)
	private String name;
	@Column(length = 15)
	private String city;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "show_time", 
			joinColumns = {@JoinColumn(name = "mpex_id")},
			inverseJoinColumns = {@JoinColumn(name = "mov_id")})
	private Set<Movie> movies = new HashSet<Movie>();

	// Getters and Setters
	public int getMpexid() {
		return mpexid;
	}
	public void setMpexid(int mpexid) {
		this.mpexid = mpexid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public Set<Movie> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
}
