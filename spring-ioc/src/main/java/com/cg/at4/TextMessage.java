package com.cg.at4;

import org.springframework.stereotype.Component;

@Component("sms")
public class TextMessage implements Message {

	public TextMessage() {
		System.out.println("-- TextMessage constructor");
	}
	
	public void send(String to, String msg) {
		System.out.println("SMS send to " + to + " as " + msg);
	}

}
