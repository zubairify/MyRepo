package com.cg.ex2;

public class Stock {

	public Stock() {
		System.out.println("-- Default constructor");
	}
	
	private static Stock stk;
	
	public static Stock get() {
		System.out.println("-- Stock singleton");
		if(stk == null)
			stk = new Stock();
		
		return stk;
	}
}
