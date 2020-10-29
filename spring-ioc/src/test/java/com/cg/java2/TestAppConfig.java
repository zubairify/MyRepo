package com.cg.java2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAppConfig {

	@Test
	public void testConfig() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Alfa a = (Alfa) ctx.getBean(Alfa.class);
		a.demo();
	}
}
