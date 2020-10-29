package com.cg.at2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStock {

	@Test
	public void testStock() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("annotate.xml");
		
		ctx.getBean("s");
		
		ctx.getBean("s");
		
		ctx.getBean("s");
	}
}
