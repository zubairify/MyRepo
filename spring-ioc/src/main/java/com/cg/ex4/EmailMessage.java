package com.cg.ex4;

public class EmailMessage implements Message {

	public EmailMessage() {
		System.out.println("-- EmailMessage constructor");
	}
	
	public void send(String to, String msg) {
		System.out.println("Email send to " + to + " as " + msg);
	}

}
