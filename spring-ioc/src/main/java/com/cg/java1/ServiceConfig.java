package com.cg.java1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
	
	@Bean(name = "some")
	public SomeService getService() {
		return new SomeService();
	}

}
