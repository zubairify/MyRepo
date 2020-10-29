package com.cg.ex4;

public class WhatsappMessage implements Message {
	
	public WhatsappMessage() {
		System.out.println("-- WhatsappMessage constructor");
	}
	
	public void send(String to, String msg) {
		System.out.println("Whatsapp send to " + to + " as " + msg);
	}

}
