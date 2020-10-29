package com.cg.ex4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MessageProcessor implements ApplicationContextAware {
	private ApplicationContext ctx;
	
	public MessageProcessor() {
		System.out.println("-- MessageProcessor constructor");
	}
	
	public void process(String type, String to, String msg) {
		Message m = ctx.getBean(type, Message.class);
		m.send(to, msg);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
		System.out.println("-- Application context injected into Message Processor");
	}
}
