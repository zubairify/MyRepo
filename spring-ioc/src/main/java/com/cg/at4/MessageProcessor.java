package com.cg.at4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("mp")
public class MessageProcessor {
	
	@Autowired
	private ApplicationContext ctx;
	
	public MessageProcessor() {
		System.out.println("-- MessageProcessor constructor");
	}
	
	public void process(String type, String to, String msg) {
		Message m = ctx.getBean(type, Message.class);
		m.send(to, msg);
	}
}
