package com.lti.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lti.entity.User;
import com.lti.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.lti.repo,com.lti.service")
public class TestUser {

	@Autowired
	private UserService service;
	
	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("Amar Khan");
		user.setUsername("amar");
		user.setPassword("akbar");
		user.setEmail("anthony");
		user.setRole("Admin");
		user.setPhone("IDontKnow");
		
		service.saveUser(user);
	}
}
