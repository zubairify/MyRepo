package com.cg.ex4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMessage {

	@Test
	public void testSend() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex4ctx.xml");
		
		MessageProcessor mp = (MessageProcessor) ctx.getBean("mp");
		
		mp.process("sms","9820108880", "Hello there!");
		mp.process("email","zubair@mail.com","Got your mail");
		mp.process("wap", "9707123987", "Hola Whatsup?!");
		
	}
}
