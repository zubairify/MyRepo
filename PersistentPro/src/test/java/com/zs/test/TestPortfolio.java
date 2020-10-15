package com.zs.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.zs.one2manyuni.Portfolio;
import com.zs.one2manyuni.Share;

public class TestPortfolio {

	private EntityManagerFactory factory;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("MyPU");
	}

	@Test
	public void testAddPortfolio() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Portfolio p1 = new Portfolio();
		p1.setHolder("Polo");
		
		Share s1 = new Share();
		s1.setStock("LTI");
		s1.setQuantity(100);
		s1.setQuote(1740);
		
		Share s2 = new Share();
		s2.setStock("RIL");
		s2.setQuantity(50);
		s2.setQuote(1460);
		
		p1.getShares().add(s1);
		p1.getShares().add(s2);
		
		em.persist(p1);
		txn.commit();
		
		em.close();
	}
	
	@Test
	public void testFetchPortfolio() {
		EntityManager em = factory.createEntityManager();
		
		Portfolio p1 = em.find(Portfolio.class, 3);
		System.out.println("Holder: " + p1.getHolder());
		p1.getShares().stream().forEach(System.out::println);
		
		em.close();
	}
}
