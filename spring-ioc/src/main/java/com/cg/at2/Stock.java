package com.cg.at2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Stock {
	
	public Stock() {
		System.out.println("-- Default constructor");
	}
	
	private static Stock stk;
	
	@Bean(name = "s")
	public static Stock get() {
		System.out.println("-- Singleton method");
		if(stk == null)
			stk = new Stock();
		
		return stk;
	}
}
