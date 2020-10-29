package com.cg.ex1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloWorld {

	@Test
	public void testGreeting() {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("ex1.xml");
		
		HelloWorld hello = (HelloWorld) appCtx.getBean("hola");
		
		System.out.println("Greeting: " + hello.getGreeting());
	}
}
