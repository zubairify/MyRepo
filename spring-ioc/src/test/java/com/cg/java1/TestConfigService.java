package com.cg.java1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfigService {

	@Test
	public void testJavaConfig() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ServiceConfig.class);
		
		SomeService some = (SomeService) ctx.getBean("some");
		some.doSomething();
	
	}
}
