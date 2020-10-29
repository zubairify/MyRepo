package com.cg.at3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class MyLife {
	
	public MyLife() {
		System.out.println("-- Default constructor");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("-- Init life-cycle method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("-- Destroy life-cycle method");
	}
}
