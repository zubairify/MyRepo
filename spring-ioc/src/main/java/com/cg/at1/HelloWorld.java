package com.cg.at1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hello")
public class HelloWorld {
	private String greeting;
	
	public HelloWorld() {
		System.out.println("-- Default constructor");
	}

	public HelloWorld(String greeting) {
		this.greeting = greeting;
		System.out.println("-- Parameterized constructor");
	}

	public String getGreeting() {
		return greeting;
	}

	@Value("Hello Spring")
	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("-- Setter method");
	}
}
