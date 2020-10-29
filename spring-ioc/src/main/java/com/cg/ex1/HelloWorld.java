package com.cg.ex1;

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

	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("-- Setter method");
	}
}
