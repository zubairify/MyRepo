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

public class TestJPAQuery {
	private EntityManagerFactory factory;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("MyPU");
	}

	@Test
	public void testGetCustomer() {
		EntityManager em = factory.createEntityManager();
//		String jpql = "FROM Customer";
//		String jpql = "FROM Customer WHERE creditLimit >= 5000";
//		String jpql = "FROM Customer WHERE creditLimit >= 5000 ORDER BY custName";
//		String jpql = "FROM Customer WHERE creditLimit >= 5000 ORDER BY creditLimit";	
//		String jpql = "FROM Customer WHERE creditLimit > 5000 AND creditLimit < 7000";
		String jpql = "FROM Customer WHERE creditLimit BETWEEN 500 AND 700";
		
		Query q1 = em.createQuery(jpql);
		List<Customer> cust =  q1.getResultList();
		
		if(cust.size() == 0)
			System.out.println("No customers found with the matching criteria");
		
		for (Customer c : cust) 
			System.out.println(c.getCustName() + "\t" + c.getCity() + "\t" + c.getCreditLimit());
		
		em.close();
	}
	
	@Test
	public void testGetSpecificFields() {
		EntityManager em = factory.createEntityManager();
		
		String jpql = "SELECT custName, creditLimit FROM Customer";
		
		Query q1 = em.createQuery(jpql);

		List<Object[]> cust =  q1.getResultList();
		
		for (Object[] s : cust) 
			System.out.println(s[0] + "\t" + s[1]);
		
		em.close();
	}
	
	@Test
	public void testProjectionQuery() {
		EntityManager em = factory.createEntityManager();
		
		String jpql = "SELECT new com.lti.pojo.PartCustomer(c.custName, c.creditLimit) FROM Customer c";
		
		Query q1 = em.createQuery(jpql, PartCustomer.class);

		List<PartCustomer> cust =  q1.getResultList();
		
		for (PartCustomer c : cust) 
			System.out.println(c.getCustName() + "\t" + c.getCreditLimit());
		
		em.close();
	}
	
	@Test
	public void testGetParamQuery() {
		EntityManager em = factory.createEntityManager();
		
		String jpql = "FROM Customer WHERE creditLimit BETWEEN :low AND :high";
		
		Query q1 = em.createQuery(jpql);
		q1.setParameter("low", 5000.0);
		q1.setParameter("high", 7000.0);

		List<Customer> cust =  q1.getResultList();
		
		for (Customer c : cust) 
			System.out.println(c.getCustName() + "\t" + c.getCity() + "\t" + c.getCreditLimit());
		
		em.close();
	}
	
	@Test
	public void testNamedQuery() {
		EntityManager em = factory.createEntityManager();
		
//		Query q1 = em.createNamedQuery("highlimit");
		Query q1 = em.createNamedQuery("lowlimit");
		q1.setParameter("crl", 5000.0);

		List<Customer> cust =  q1.getResultList();
		
		for (Customer c : cust) 
			System.out.println(c.getCustName() + "\t" + c.getCity() + "\t" + c.getCreditLimit());
		
		em.close();
	}
}
