package com.cg.at1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloWorld {
	
	@Test
	public void testGreeting() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("annotate.xml");
		
		HelloWorld hello = (HelloWorld) ctx.getBean("hello");
		
		System.out.println("Greeting: " + hello.getGreeting());
		
	}
}
