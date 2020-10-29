package com.cg.ex4;

public class TextMessage implements Message {

	public TextMessage() {
		System.out.println("-- TextMessage constructor");
	}
	
	public void send(String to, String msg) {
		System.out.println("SMS send to " + to + " as " + msg);
	}

}
