package com.cg.at4;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("wap")
@Lazy
public class WhatsappMessage implements Message {
	
	public WhatsappMessage() {
		System.out.println("-- WhatsappMessage constructor");
	}
	
	public void send(String to, String msg) {
		System.out.println("Whatsapp send to " + to + " as " + msg);
	}

}
