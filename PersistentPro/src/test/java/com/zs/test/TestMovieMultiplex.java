package com.zs.test;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.zs.many2many.Movie;
import com.zs.many2many.Multiplex;

public class TestMovieMultiplex {

	private EntityManagerFactory factory;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("MyPU");
	}

	@Test
	public void testAddMovieAndMultiplex() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		
		Multiplex mpex1 = new Multiplex();
		mpex1.setName("INOX");
		mpex1.setCity("Thane");
		
		Multiplex mpex2 = new Multiplex();
		mpex2.setName("PVR");
		mpex2.setCity("Pune");
		
		Movie mov1 = new Movie();
		mov1.setTitle("Black Panther");
		mov1.setRating(4.5);
		
		Movie mov2 = new Movie();
		mov2.setTitle("Jumanji");
		mov2.setRating(3.5);
		
		mpex1.getMovies().add(mov1);
		mpex1.getMovies().add(mov2);
		
		mpex2.getMovies().add(mov1);
		mpex2.getMovies().add(mov2);
		
		em.persist(mpex1);
		em.persist(mpex2);
		
		txn.commit();
		em.close();
	}
	
	@Test
	public void testFetchMutiplex() {
		EntityManager em = factory.createEntityManager();
		
		Multiplex mpex = em.find(Multiplex.class, 1352);
		System.out.println(mpex.getName() + "\t" + mpex.getCity());
		Set<Movie> movies = mpex.getMovies();
		for (Movie movie : movies) 
			System.out.println(movie.getTitle());	
	}
}
