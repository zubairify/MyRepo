package com.cg.at4;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailMessage implements Message {

	public EmailMessage() {
		System.out.println("-- EmailMessage constructor");
	}
	
	public void send(String to, String msg) {
		System.out.println("Email send to " + to + " as " + msg);
	}

}
