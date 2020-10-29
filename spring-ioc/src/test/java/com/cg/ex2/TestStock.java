package com.cg.ex2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStock {

	@Test
	public void testStock() {
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("ex2.xml");
		
		appCtx.getBean("s");
		
		appCtx.getBean("s");
		
		appCtx.getBean("s");
	}
}
