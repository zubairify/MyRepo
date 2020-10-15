package com.zs.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.zs.inheritance.tableperclass.Account;
import com.zs.inheritance.tableperclass.Card;

public class TestTablePerClass {
	private EntityManagerFactory factory;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("MyPU");
	}

	@Test
	public void testAddAccount() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		txn.begin();
		Account a1 = new Account();
		a1.setCustName("Polo");
		a1.setNumber("1234567");
		a1.setBankName("ICICI");

		em.persist(a1);
		txn.commit();
		em.close();
	}

	@Test
	public void testAddCard() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		txn.begin();
		Card c1 = new Card();
		c1.setCustName("Mona");
		c1.setNumber("9384628234");
		c1.setCardType("VISA");

		em.persist(c1);
		txn.commit();
		em.close();
	}
}
