package com.zs.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.zs.naturalid.Book;

public class TestBook {
private EntityManagerFactory factory;
	
	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("MyPU");
	}
	
	@Test
	public void testAddBook() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Book b1 = new Book();
		b1.setIsbn("123-456-90");
		b1.setTitle("The Prophet");
		b1.setAuthor("Khalil Gibran");
		
		em.persist(b1);
		txn.commit();
		em.close();
	}
	
	@Test
	public void testFetchByIsbn() {
		EntityManager em = factory.createEntityManager();
		Session session = em.unwrap(Session.class);
		// code to fetch by isbn / natural id
		Book b1 = session.bySimpleNaturalId(Book.class).load("123-456-90");
		// print book details
		System.out.println(b1.getTitle() + "\t" + b1.getAuthor());
		em.close();
	}
	
	// L1 Cache - Limited to a session/entity manager instance. It is built in inside Hibernate
	// Beyond that L2 cache is required, acheived using 3rd party libraries
	// Most popular and compatible with Hibernate L2 cache library is "ehcache" 
	// Caching is generally for retrieved data. Its read only in nature
	@Test
	public void testFetchBook() {
		EntityManager em = factory.createEntityManager();
		
		Book b1 = em.find(Book.class, 8);
		System.out.println(b1.getTitle() + "\t" + b1.getAuthor());
		
		em.close();
		
		em = factory.createEntityManager();
		
		Book b2 = em.find(Book.class, 8);
		System.out.println(b2.getTitle() + "\t" + b2.getAuthor());
		
		em.close();
	}
	
}
