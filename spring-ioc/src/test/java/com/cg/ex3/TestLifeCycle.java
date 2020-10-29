package com.cg.ex3;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycle {

	@Test
	public void testLife() {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("ex3ctx.xml");
		
		ctx.getBean(MyLife.class);
		
		ctx.close();
	}
}
