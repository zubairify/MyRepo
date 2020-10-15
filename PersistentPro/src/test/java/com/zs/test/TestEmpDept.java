package com.zs.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.zs.one2manybi.Department;
import com.zs.one2manybi.Employee;

public class TestEmpDept {
	private EntityManagerFactory factory;
	
	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("MyPU");
	}
	
	@Test
	public void testAddDepartment() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Department d1 = new Department();
		d1.setDeptId(10);
		d1.setDeptName("sales");
		em.persist(d1);
		txn.commit();
		
		em.close();
	}
	
	@Test
	public void testAddEmployee() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Employee e1 = new Employee();
		e1.setEmpName("Polo");
		e1.setSalary(5000);
		
		Department d1 = em.find(Department.class, 10);
		e1.setDept(d1);
		
		em.persist(e1);
		txn.commit();
		
		em.close();
	}
	
	@Test
	public void testAddDeptEmp() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Department d1 = new Department();
		d1.setDeptId(20);
		d1.setDeptName("IT");
		
		Employee e1 = new Employee();
		e1.setEmpName("Duke");
		e1.setSalary(4000);
		e1.setDept(d1);	// setting parent to the child object
		
		d1.getEmployees().add(e1);	// adding child object to parent's list
		
		em.persist(d1);
		txn.commit();
		
		em.close();
	}
	
	@Test
	public void testDeleteDept() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Department d1 = em.find(Department.class, 20);
		
		em.remove(d1);
		
		txn.commit();
		
		em.close();
	}
	
	@Test
	public void testFetchDept() {
		EntityManager em = factory.createEntityManager();
		
		Department d1 = em.find(Department.class, 10);
		System.out.println("Dept Name: " + d1.getDeptName());
		System.out.println("No of employees in dept 10: " + d1.getEmployees().size());
	}
}
