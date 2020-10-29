package com.cg.java2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.cg.at4.Message;

@Component
@Lazy
public class Beta {
	
	@Autowired
	@Qualifier("sms")	// Autowire by name/id
	private Message msg;

	public Beta() {
		System.out.println("-- Beta constructor");
	}
	
	public void sample() {
		System.out.println("Sample beta method");
	}
}
