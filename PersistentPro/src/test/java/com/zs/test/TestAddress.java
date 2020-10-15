package com.zs.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.zs.one2one.Address;
import com.zs.one2one.Person;

public class TestAddress {

	private EntityManagerFactory factory;
	
	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("MyPU");
	}
	
	@Test
	public void testAddPerson() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Person p1 = new Person();
		p1.setName("Polo");
		p1.setAge(21);
		
		Address ad1 = new Address();
		ad1.setStreet("Oakwood Driver");
		ad1.setCity("Fairfax");
		ad1.setLandmark("Wallmart");
		ad1.setPincode("110000");
		
		p1.setAdd(ad1);
		ad1.setP(p1);
		
		em.persist(p1);
		txn.commit();
		
		em.close();
	}
	
	@Test
	public void testFetchPerson() { 
		EntityManager em = factory.createEntityManager();
		
		Person p1 = em.find(Person.class, 9);
		System.out.println(p1.getName());
		Address a1 = p1.getAdd();
		System.out.println(a1.getStreet());
		System.out.println(a1.getCity());
		
		em.close();
	}
}
