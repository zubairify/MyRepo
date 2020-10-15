package com.zs.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.zs.compositeid.Citizen;

public class TestCitizen {
	private EntityManagerFactory factory;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("MyPU");
	}

	@Test
	public void testAddCitizen() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Citizen.Passport pp = new Citizen.Passport("India", 123456);
		Citizen c1 = new Citizen();
		c1.setId(pp);
		c1.setName("Polo");
		c1.setAge(21);
		
		em.persist(c1);
		txn.commit();
		
		em.close();
	}
	
	
}
