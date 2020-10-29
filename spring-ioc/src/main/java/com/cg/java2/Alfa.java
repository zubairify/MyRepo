package com.cg.java2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Alfa {

	@Autowired
	@Lazy
	private Beta b;
	
	public Alfa() {
		System.out.println("-- Alfa constructor");
	}
	
	public void demo() {
		System.out.println("Alfa demo method");
		b.sample();
	}
}
