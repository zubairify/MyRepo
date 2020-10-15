package com.zs.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.zs.entity.Customer;

public class TestCustomer {
	
	private EntityManagerFactory factory;
	
	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("MyPU");
	}
	
	@Test
	public void testAddCustomer() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Customer c1 = new Customer();
		c1.setCustName("Ruhi");
		c1.setCity("Rajkot");
		c1.setCreditLimit(6000);
		
		em.persist(c1);
		txn.commit();
		em.close();
	}
	
	@Test
	public void fetchCustomer() {
		EntityManager em = factory.createEntityManager();
	
		Customer c1 = em.find(Customer.class, 1);
		System.out.println(c1.getCustName() + "\t" + c1.getCity());
		
		em.close();
	}
	
	@Test
	public void testUpdateCustomer() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Customer c1 = em.find(Customer.class, 101);
		c1.setCity("Lavasa");
		em.merge(c1);
		txn.commit();
		em.close();
	}
	
	@Test
	public void testAddWithMerge() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Customer c1 = new Customer();
		c1.setCustName("Niha");
		c1.setCity("Nagpur");
		c1.setCreditLimit(3000);
		
		em.merge(c1);
		txn.commit();
		em.close();
	}
	
	// Merge method if finds existing record it updates or inserts new record if not found.
	@Test
	public void testUpdateWithoutFind() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Customer c1 = new Customer();
		c1.setCustId(202);
		c1.setCustName("Sayan");
		c1.setCity("Sivan");
		c1.setCreditLimit(4000);
		
//		em.merge(c1);
		em.persist(c1);
		txn.commit();
		em.close();
	}
	
	@Test
	public void testDeleteCustomer() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Customer c1 = em.find(Customer.class, 101);
		em.remove(c1);
		txn.commit();
		em.close();
	}
	
	// Entity state
	// 1-Sychronised state : Changes made to the entity state directly reflects in the db table.
	// 2-Detached state: Changes made has to explicitly updated into the table
	@Test
	public void testDetached() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Customer c1 = em.find(Customer.class, 101);
		txn.commit();
		
		c1.setCity("Nerul");
		
		txn.begin();
		em.persist(c1);
		txn.commit();
		
		em.close();
	}
}
