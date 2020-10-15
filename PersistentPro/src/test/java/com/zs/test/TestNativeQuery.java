package com.zs.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import com.zs.entity.Customer;
import com.zs.pojo.PartCustomer;

public class TestNativeQuery {
	private EntityManagerFactory factory;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("MyPU");
	}

	@Test
	public void testGetCustomer() {
		EntityManager em = factory.createEntityManager();
		
		String sql = "SELECT * FROM customers";
		Query q1 = em.createNativeQuery(sql, Customer.class);
		
		List<Customer> cust = q1.getResultList();
		
		for (Customer c : cust) {
			System.out.println(c.getCustName() + "\t" + c.getCreditLimit());
		}
	}
	
	@Test
	public void testGetProjection() {
		EntityManager em = factory.createEntityManager();
		
		String sql = "SELECT cust_name, cr_limit FROM customers";
		Query q1 = em.createNativeQuery(sql, PartCustomer.class);
		
		List<PartCustomer> cust = q1.getResultList();
		
		for (PartCustomer c : cust) {
			System.out.println(c.getCustName() + "\t" + c.getCreditLimit());
		}
	}
}
