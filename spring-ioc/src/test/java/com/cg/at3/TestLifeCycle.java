package com.cg.at3;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycle {

	@Test
	public void testLife() {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("annotate.xml");
		
		ctx.getBean(MyLife.class);
		
		ctx.close();
	}
}
