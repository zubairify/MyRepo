package com.zs.compositeid;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Citizen {
	@EmbeddedId
	private Passport id;
	
	@Column(length = 20)
	private String name;
	private int age;
	
	@Embeddable
	public static class Passport implements Serializable {
		@Column(length = 15)
		private String country;
		@Column(name = "passport_no")
		private int number;
		
		public Passport() {
		}

		public Passport(String country, int number) {
			this.country = country;
			this.number = number;
		}

		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}

		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		
		@Override
		public int hashCode() {
			return number + country.hashCode();
		}

		@Override
		public String toString() {
			return "Passport [country=" + country + ", number=" + number + "]";
		}
	};

	public Passport getId() {
		return id;
	}
	public void setId(Passport id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Citizen [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
